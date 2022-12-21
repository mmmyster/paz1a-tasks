package sk.paz1a.practicals;

public class Odber {
	private String menoZamestnanca;
	private String datumOdberu;
	private int odberneMiesto;
	private boolean vysledok;

	public Odber(String menoZamestnanca, String datumOdberu, int odberneMiesto, boolean vysledok) {
		super();
		this.menoZamestnanca = menoZamestnanca;
		this.datumOdberu = datumOdberu;
		this.odberneMiesto = odberneMiesto;
		this.vysledok = vysledok;
	}

	@Override
	public String toString() {
		return menoZamestnanca + ", " + datumOdberu + ", " + odberneMiesto + ", " + vysledok;
	}

	public String getMenoZamestnanca() {
		return menoZamestnanca;
	}

	public String getDatumOdberu() {
		return datumOdberu;
	}

	public int getOdberneMiesto() {
		return odberneMiesto;
	}

	public boolean getVysledok() {
		return vysledok;
	}

	/**
	 * Vygenerovana metoda hashCode, metodu neupravujte
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datumOdberu == null) ? 0 : datumOdberu.hashCode());
		result = prime * result + ((menoZamestnanca == null) ? 0 : menoZamestnanca.hashCode());
		result = prime * result + odberneMiesto;
		result = prime * result + (vysledok ? 1231 : 1237);
		return result;
	}

	/**
	 * Vygenerovana metoda equals, ktora zisti, ci objekt triedy odber je rovnaky
	 * ako parameterom zadany objekt obj. Metodu neupravujte
	 *
	 * @param obj porovnavany objekt
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Odber other = (Odber) obj;
		if (datumOdberu == null) {
			if (other.datumOdberu != null)
				return false;
		} else if (!datumOdberu.equals(other.datumOdberu))
			return false;
		if (menoZamestnanca == null) {
			if (other.menoZamestnanca != null)
				return false;
		} else if (!menoZamestnanca.equals(other.menoZamestnanca))
			return false;
		if (odberneMiesto != other.odberneMiesto)
			return false;
		if (vysledok != other.vysledok)
			return false;
		return true;
	}
}
