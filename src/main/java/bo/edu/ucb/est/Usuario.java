package bo.edu.ucb.est;

public class Usuario {
	public Long userId;
	public int flag;
	private int opcion;
	private int num1;
	private int num2;
	
	public Usuario(Long userId,int flag) {
		this.userId=userId;
		this.flag=flag;
	}

	public Long getUserId() {
		return userId;
	}

	public int getFlag() {
		return flag;
	}

	public int getOpcion() {
		return opcion;
	}

	public int getNum1() {
		return num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setUserId(Long userId) {
		this.userId=userId;
	}
	
	public void setFlag(int flag) {
		this.flag=flag;
	}
	
	public void setOpcion(int opcion) {
		this.opcion=opcion;
	}
	
	public void setNum1(int num1) {
		this.num1=num1;
	}
	
	public void setNum2(int num2) {
		this.num2=num2;
	}
	
	@Override
	public String toString() {
		return "Usuario [userId="+userId+", flag="+flag+", opcion="+opcion+", num1="+num1+", num2="+num2+"]\n";
	}
}
