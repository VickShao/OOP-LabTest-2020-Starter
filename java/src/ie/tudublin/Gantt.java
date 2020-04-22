package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	public ArrayList<Task> tasks = new ArrayList<Task>();
	public float bound = width * 0.05f;
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
		
		float bound = width * 0.05f;
		float z = 0;
		for(int i = 0; i< 9;i++){
			float y= map(i,0,tasks.size(),height*0.1f,height-200);
			fill(255);
			text(tasks.get(i).Get_task(),40,y+30);
			
			for(int j=1;j<31;j++)
			{
						
						float x = map(j,1,31,bound+100,width-bound);
						if(j==tasks.get(i).Get_start())
						{
							int days = (tasks.get(i).Get_end()-tasks.get(i).Get_start());
							colorMode(HSB);
							fill(0+z,255,255);
							rect(x,y+10,days*(width-bound-bound-120)/29,30,7);
							z+=29;
						}
	
			}
			//float x = map(i,1,31,bound+100,width-bound);
			//rect(bound+100+((tasks.get(i).Get_start()-1)*(width-bound-bound-120)/29),y+10,(tasks.get(i).Get_end()-tasks.get(i).Get_start())*(width-bound-bound-120)/29,30,7);
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
		colorMode(HSB);
		background(0);

		float bound = width * 0.05f;
		stroke(255);
		
		for(int i=1;i<31;i++){
			
			float x = map(i,1,31,bound+100,width-bound);
			fill(255);
			text((int)i,x-5,30);
			line(x,bound,x,height-bound);
		}

		printTasks();
	}
}
