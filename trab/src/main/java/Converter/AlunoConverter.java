package Converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import cdp.classesAnemicas.Aluno;
import cgt.backingbean.AlunoBean;

@FacesConverter(forClass = Aluno.class)
public class AlunoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String codigoString) {
		// TODO Auto-generated method stub
		if(codigoString != null && codigoString.trim().length()>0)
		{
			Integer codigo = Integer.valueOf(codigoString);
			
			AlunoBean alunobean = new AlunoBean();
			
			return alunobean.getAlunoPorCodigo(codigo);
			
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object alunoObjeto) {
		// TODO Auto-generated method stub
		if(alunoObjeto != null)
		{
			Aluno aluno = (Aluno)alunoObjeto;
			return aluno.getFoto().toString();
			
		}
		return null;
		
	}

}
