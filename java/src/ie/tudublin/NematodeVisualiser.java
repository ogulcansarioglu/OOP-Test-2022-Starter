package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();
	public float border;
	public float index = 0;

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
			index++;
			//error checking code
			if (index == nematodes.size()) {
				index = 0;
			}
		}		
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();
		loadNematodes();
		border = width * 0.1f;				
	}
	

	public void loadNematodes()
	{
		Table table = loadTable("nematodes.csv", "header");
		for(TableRow r: table.rows()) 
		{
			Nematode nm = new Nematode(r);
			nematodes.add(nm);
		}
	}


	public void draw()
	{
		background(0);
		stroke(255,0,225);
		line(border, height/2, border + 200, height/2);
		fill(255);
		stroke(255,0,225);
		line(width - border, height/2, width - border - 200, height/2);
		fill(255);
		stroke(255,0,225);
		line(width - border, height/2, width - border - 50, height/2 * 0.8f);
		fill(255);
		stroke(255,0,225);
		line(width - border, height/2, width - border - 50, height/2 * 1.2f);
		fill(255);
		stroke(255,0,225);
		line(border, height/2, border + 50, height/2 * 1.2f);
		fill(255);
		stroke(255,0,225);
		line(border, height/2, border + 50, height/2 * 0.8f);
		fill(255);
		textAlign(CENTER);
		textSize(20);
		text(nematodes.get(0).getName(), width/2,  height/2 - height/3);
		

		



		fill(255);
	}
}
