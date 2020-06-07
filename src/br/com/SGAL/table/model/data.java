
package br.com.SGAL.table.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class data {
  
  private Date data;

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return data;
    }
  
  private data(String data) throws ParseException{
      
    this.data = new SimpleDateFormat("dd/MM/yyyy").parse(data);
  }
  //Método Getter e Setter
  
}
