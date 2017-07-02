package Trabalho_20171.trab;

import cgd.crudjdbc.DadosPessoaisCrudJDBC;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	//AlunoCrudJDBC teste = new AlunoCrudJDBC();
    	
    	//ArrayList<Aluno> listaAlunos = (ArrayList<Aluno>) teste.listar();
    	//System.out.println(listaAlunos.get(0).getDadosPessoais().getDatNasc());
    	//for(int i=0; i<listaAlunos.size(); i++)
    	//{
    		//System.out.println(listaAlunos.get(i).getDadosPessoais());
    	//}
    	
    	
    	System.out.println(DadosPessoaisCrudJDBC.getDadosPessoais(341).getNome());
    }
}
