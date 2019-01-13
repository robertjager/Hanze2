package nl.hanze.zzz.hulp;

import java.io.FileInputStream;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class GetInfo {

	private String kenteken;
	
	public String getKenteken() {
		return kenteken;
	}
	
	public void setKenteken(String kenteken){
		this.kenteken = kenteken;
	}

	// C:\Users\rihh\Documents\Hanze\Themas\Thema 4.2 WAD\03 Practicum informatie\Code opdrachten\OLA
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
	    XStream xStream = new XStream(new StaxDriver());
	    xStream.alias("GetInfo", GetInfo.class);
	    FileInputStream file;
        file = new FileInputStream("C:\\Users\\rihh\\Documents\\Hanze\\Themas\\Thema 4.2 WAD\\03 Practicum informatie\\Code opdrachten\\OLA\\tekstje.txt");
        GetInfo a = (GetInfo) xStream.fromXML(file);
        System.out.println(a.getKenteken());	   
	}
}
