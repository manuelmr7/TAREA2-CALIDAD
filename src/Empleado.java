
public class Empleado {
	
	public static float calcularNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra)
	{
		if(tipo==null || tipo==TipoEmpleado.OTRO || ventasMes<0.0f || horasExtra<0.0f)
		{
			return -1.0f;
		}
		float salarioBase=0.0f;
		if(tipo==TipoEmpleado.VENDEDOR)
		{
			salarioBase=2000.0f;
		}
		else
		{
			salarioBase=2500.0f;
		}
		float prima=0.0f;
		if(ventasMes>=1500.0f)
		{
			prima=200.0f;
		}
		else if(ventasMes>=1000.0f)
		{
			prima=100.0f;
		}
		float complementoHoras=horasExtra*30.0f;
		return salarioBase+prima+complementoHoras;
		
	}
	float calculoNominaNeta(float nominaBruta)
	{
		if(nominaBruta <0.0f)
		{
			return -1.0f;
		}
		float retencion=0.0f;
		if(nominaBruta>=2500.0f)
		{
			retencion=0.18f;
		}
		else if(nominaBruta>=2100.0f)
		{
			retencion=0.15f;
		}
		else
		{
			retencion=0.0f;
		}
		return nominaBruta*(1.0f-retencion);
	}

}
