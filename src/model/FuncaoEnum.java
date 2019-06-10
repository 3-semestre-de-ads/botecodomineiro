package model;

public enum FuncaoEnum {

	Ambos("2", "Ambos"), Atendentes("0", "Atendentes"), Administradores("1", "Administradores");

	private String cod;
	private String desc;

	private FuncaoEnum(String cod, String desc) {
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
