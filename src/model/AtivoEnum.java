package model;

public enum AtivoEnum {

	Ambos("2", "Ambos"), Inativo("0", "Inativo"), Ativo("1", "Ativo");

	private String cod;
	private String desc;

	private AtivoEnum(String cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
