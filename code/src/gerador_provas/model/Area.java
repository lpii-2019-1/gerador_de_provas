package gerador_provas.model;

public class Area {
	private int idarea;
	private String area;

	public String getArea() { return area;}

	public void setArea(String area) { this.area = area; }

	public int getIdarea() { return idarea; }

	public void setIdarea(int idarea) {this.idarea = idarea;}
	
	public Area() {
		
	}
	public Area(String area) {
		this.area = area;
	}
	public Area(int idarea, String area) {
		this.idarea = idarea;
		this.area = area;
	}
	
}
