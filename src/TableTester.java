import java.util.ArrayList;

import javax.swing.JTable;


public class TableTester 
{
	private ArrayList<Book> books;
	private String[] colNames;
	
	public TableTester(String[] columnNames, ArrayList<Book> books)
	{
		this.books = books;
		this.colNames = columnNames;
		
	}
	
	
	public JTable draw()
	{
		Object[][] gen = new Object[books.size()][colNames.length];
		for(int i =0; i < books.size(); i++)
		{
			
				gen[i][0] = books.get(i).getBookId();
				gen[i][1] = books.get(i).getTitle();
				gen[i][2] = books.get(i).getAuthor();
				gen[i][3] = books.get(i).getCopies();
				gen[i][4] = books.get(i).getLocationId();
						
			
		}
		
		JTable table = new JTable(gen, colNames);
		return table;
		
		
		
		
		
		
	}

}
