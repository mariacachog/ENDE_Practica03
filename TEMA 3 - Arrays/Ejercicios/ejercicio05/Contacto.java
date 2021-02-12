package ejercicio05;

public class Contacto implements Comparable //Puesto que vamos a modificar los métodos toString y compareTo de la clase Comparable, es preciso implementarla 
{
	private String nombre;
	private String telefono;
	private String email;
	
	
	//Constructor
	public Contacto(String nombre, String telefono, String email)
	{
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}
	
	//Métodos Set y Get
	public String getNombre()
	{
		return nombre;
	}


	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getTelefono()
	{
		return telefono;
	}
	
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	

	// Sobreescribimos el método toString para que nos muestre la información del contacto
	// OJO: Si no hacemos esto, el método toString original nos imprimirá nombreClase@referenciaObjetos
	@Override
	public String toString()
	{
		return nombre + ", " + telefono + ", " + email;
	}
	
	/* El System.out.print ejecuta automáticamente el método toString()
	 * por lo tanto, una vez sobreescrito el método toString(), nos dará igual llamarlo de cualquiera
	 * de estas dos formas: System.out.println(contacto1); o System.out.println(contacto1.toString());*/
	
	///////////////////////////////////////
	public boolean equals(Contacto contacto)
	{
		return nombre.equals(contacto.getNombre()) && telefono.equals(contacto.getTelefono()) 
				&& email.equals(contacto.getEmail());	  
	}
	//////////////////////////////////////////////
	@Override
	public int compareTo(Object arg0) 
	{
		Contacto contacto = (Contacto) arg0;
		return nombre.compareTo(contacto.getNombre());
	}
	//////////////////////////////////////////////////
	public int compareTo(Contacto contacto)
	{
		return nombre.compareTo(contacto.getNombre());
	}
	
}
