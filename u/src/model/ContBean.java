package model;
import java.io.Serializable;
import java.sql.Blob;

public class ContBean {
	private int contId ;
	private String contName;
	private String start;
	private String end;
	private String note;
	private Blob blob;
	private int imageId;


	public int getContId() {
		return contId;
	}
	public void setContId(int contId) {
		this.contId = contId;
	}
	public String getContName() {
		return contName;
	}
	public void setContName(String contName) {
		this.contName = contName;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String string) {
		this.end = string;
	}
	public String getStart(){
		return start;
	}
	public void setStart(String string) {
		this.start =string;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Blob  getBlob() {
		return blob;
	}
	public void setBlob(Blob blob) {
		this.blob = blob;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
}
