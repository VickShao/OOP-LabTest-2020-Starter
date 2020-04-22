package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	public ArrayList<Task> tasks = new ArrayList<Task>();
	
	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table t = loadTable("tasks.csv","header");
		for(TableRow row:t.rows()){
			Task c = new Task(row);
			tasks.add(c);
		}
	}

	public void printTasks()
	{
		
		for(int i = 0; i< 9;i++){
			float y= map(i,0,tasks.size(),height*0.1f,height-200);
			text(tasks.get(i).Get_task(),40,y+30);
		}

		/* for(Task t:tasks){
			String i= t.Task;
			int j = 1;
			//print(i);
			float y = map (j,1,9,20,600);
				
		} */
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{			
		background(0);

		float bound = width * 0.05f;
		stroke(255,255,255);
		
		for(int i=1;i<31;i++){
			
			float x = map(i,1,31,bound+100,width-bound);
			text((int)i,x-5,30);
			line(x,bound,x,height-bound);
		}

		printTasks();
	}
}
