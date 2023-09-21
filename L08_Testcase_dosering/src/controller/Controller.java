package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import pnOrdination.*;
import storage.Storage;

public class Controller {
	private Storage storage;
	private static Controller controller;

	private Controller() {
		storage = new Storage();
	}

	public static Controller getController() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}

	// Opretter og returnerer en PN ordination
	public PN opretPNOrdination(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel, double antalEnheder) {

		// Kontroller for null-værdier
		if (startDen == null || slutDen == null || patient == null || laegemiddel == null) {
			throw new IllegalArgumentException("Startdato, slutdato, patient og lægemiddel må ikke være null.");
		}

		// Kontroller om startDato er før slutDato
		if (!checkStartFoerSlut(startDen, slutDen)) {
			throw new IllegalArgumentException("Startdato skal være før slutdato");
		}

		// Kontroller om antal er større eller lig 0
		if (antalEnheder < 0) {
			throw new IllegalArgumentException("Antal skal være større eller lig 0");
		}

		// Opret og returner en PN ordination
        return new PN(startDen, slutDen, laegemiddel, antalEnheder);
	}

	// Opretter og returnerer en DagligFast ordination
	public DagligFast opretDagligFastOrdination(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel, int morgenAntal, int middagAntal, int aftenAntal, int natAntal) {

		// Kontroller for null-værdier
		if (startDen == null || slutDen == null || patient == null || laegemiddel == null) {
			throw new IllegalArgumentException("Startdato, slutdato, patient og lægemiddel må ikke være null.");
		}

		// Kontroller om startDato er før slutDato
		if (!checkStartFoerSlut(startDen, slutDen)) {
			throw new IllegalArgumentException("Startdato skal være før slutdato");
		}

		// Kontroller om antal er større eller lig 0
		if (morgenAntal < 0 || middagAntal < 0 || aftenAntal < 0 || natAntal < 0) {
			throw new IllegalArgumentException("Antal skal være større eller lig 0");
		}

		// Opret og returner en DagligFast ordination
		return new DagligFast(startDen, slutDen, morgenAntal, middagAntal, aftenAntal, natAntal, laegemiddel);
	}

	// Opretter og returnerer en DagligSkæv ordination
	public DagligSkaev opretDagligSkaevOrdination(LocalDate startDen,
			LocalDate slutDen, Patient patient, Laegemiddel laegemiddel,
			LocalTime[] klokkeSlet, double[] antalEnheder) {

		// Kontroller for null-værdier
		if (startDen == null || slutDen == null || patient == null || laegemiddel == null || klokkeSlet == null || antalEnheder == null) {
			throw new IllegalArgumentException("Ingen af parametrene må være null.");
		}

		// Kontroller om startDato er før slutDato
		if (!checkStartFoerSlut(startDen, slutDen)) {
			throw new IllegalArgumentException("Startdato skal være før slutdato");
		}

		// Kontroller om antalEnheder og klokkeSlet har samme længde
		if (antalEnheder.length != klokkeSlet.length) {
			throw new IllegalArgumentException("AntalEnheder og klokkeSlet skal have samme længde");
		}

		// Kontroller om alle tal i antalEnheder er større end 0
		for (double antal : antalEnheder) {
			if (antal < 0) {
				throw new IllegalArgumentException("Antal enheder skal være større end 0");
			}
		}

		// Opret og returner en DagligSkæv ordination
		return new DagligSkaev(startDen, slutDen, laegemiddel);
	}

	// Tilføjer en dato til en PN ordination
	public void ordinationPNAnvendt(PN ordination, LocalDate dato) {

		// Kontroller for null-værdier
		if (ordination == null || dato == null) {
			throw new IllegalArgumentException("Ordination og dato må ikke være null.");
		}

		// Kontroller om datoen er indenfor ordinationens gyldighedsperiode
		if (!ordination.gyldigDato(dato)) {
			throw new IllegalArgumentException("Datoen skal være indenfor ordinationens gyldighedsperiode");
		}

		// Tilføj datoen til ordinationen
		ordination.givDosis(dato);
	}

	// Beregner anbefalet dosis ud fra patientens vægt og returnerer denne
	public double anbefaletDosisPrDoegn(Patient patient, Laegemiddel laegemiddel) {
		double vægt = patient.getVaegt();

		// Definer de tre faktorer afhængig af patientens vægt
		double letFaktor = 0.1;
		double normalFaktor = 0.2;
		double tungFaktor = 0.3;

		double enhedPrKgPrDoegn = 0;

		// Beregn enhedPrKgPrDoegn baseret på patientens vægt
		if (vægt < 25) {
			enhedPrKgPrDoegn = letFaktor;
		} else if (vægt >= 25 && vægt <= 120) {
			enhedPrKgPrDoegn = normalFaktor;
		} else if (vægt > 120) {
			enhedPrKgPrDoegn = tungFaktor;
		}

		// Beregn og retuner den anbefalede dosis pr. døgn
		return enhedPrKgPrDoegn * vægt;
	}

	// For et givent vægtinterval og et givent lægemiddel, hentes antallet af ordinationer
	public int antalOrdinationerPrVægtPrLægemiddel(double vægtStart, double vægtSlut, Laegemiddel laegemiddel) {
		int antalOrdinationer = 0;

		for (Patient patient : storage.getAllPatienter()) {
			if (patient.getVaegt() >= vægtStart && patient.getVaegt() <= vægtSlut) {
				for (Ordination ordination : patient.getOrdinationer()) {
					if (ordination.getLaegemiddel().equals(laegemiddel)) {
						antalOrdinationer++;
					}
				}
			}
		}

		return antalOrdinationer;
	}

	public List<Patient> getAllPatienter() {
		return storage.getAllPatienter();
	}

	public List<Laegemiddel> getAllLaegemidler() {
		return storage.getAllLaegemidler();
	}

	/**
	 * Metode der kan bruges til at checke at en startDato ligger før en
	 * slutDato.
	 *
	 * @return true hvis startDato er før slutDato, false ellers.
	 */
	private boolean checkStartFoerSlut(LocalDate startDato, LocalDate slutDato) {
		boolean result = true;
		if (slutDato.compareTo(startDato) < 0) {
			result = false;
		}
		return result;
	}

	public Patient opretPatient(String cpr, String navn, double vaegt) {
		Patient p = new Patient(cpr, navn, vaegt);
		storage.addPatient(p);
		return p;
	}

	public Laegemiddel opretLaegemiddel(String navn,
			double enhedPrKgPrDoegnLet, double enhedPrKgPrDoegnNormal,
			double enhedPrKgPrDoegnTung, String enhed) {
		Laegemiddel lm = new Laegemiddel(navn, enhedPrKgPrDoegnLet,
				enhedPrKgPrDoegnNormal, enhedPrKgPrDoegnTung, enhed);
		storage.addLaegemiddel(lm);
		return lm;
	}

	public void createSomeObjects() {
		this.opretPatient("121256-0512", "Jane Jensen", 63.4);
		this.opretPatient("070985-1153", "Finn Madsen", 83.2);
		this.opretPatient("050972-1233", "Hans Jørgensen", 89.4);
		this.opretPatient("011064-1522", "Ulla Nielsen", 59.9);
		this.opretPatient("090149-2529", "Ib Hansen", 87.7);

		this.opretLaegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
		this.opretLaegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
		this.opretLaegemiddel("Fucidin", 0.025, 0.025, 0.025, "Styk");
		this.opretLaegemiddel("Methotrexat", 0.01, 0.015, 0.02, "Styk");

		this.opretPNOrdination(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 12),
				storage.getAllPatienter().get(0), storage.getAllLaegemidler()
						.get(1),
				123);

		this.opretPNOrdination(LocalDate.of(2021, 2, 12), LocalDate.of(2021, 2, 14),
				storage.getAllPatienter().get(0), storage.getAllLaegemidler()
						.get(0),
				3);

		this.opretPNOrdination(LocalDate.of(2021, 1, 20), LocalDate.of(2021, 1, 25),
				storage.getAllPatienter().get(3), storage.getAllLaegemidler()
						.get(2),
				5);

		this.opretPNOrdination(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 12),
				storage.getAllPatienter().get(0), storage.getAllLaegemidler()
						.get(1),
				123);

		this.opretDagligFastOrdination(LocalDate.of(2021, 1, 10),
				LocalDate.of(2021, 1, 12), storage.getAllPatienter().get(1),
				storage.getAllLaegemidler().get(1), 2, 0, 1, 0);

		LocalTime[] kl = { LocalTime.of(12, 0), LocalTime.of(12, 40),
				LocalTime.of(16, 0), LocalTime.of(18, 45) };
		double[] an = { 0.5, 1, 2.5, 3 };

		this.opretDagligSkaevOrdination(LocalDate.of(2021, 1, 23),
				LocalDate.of(2021, 1, 24), storage.getAllPatienter().get(1),
				storage.getAllLaegemidler().get(2), kl, an);
	}
}
