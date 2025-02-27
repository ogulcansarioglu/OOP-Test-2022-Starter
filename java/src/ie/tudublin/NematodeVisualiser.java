package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();
	public float border;
	public int index = 0;
	public boolean hasLimbs = false;
	public boolean hasEyes = true;



	public void keyPressed()
	{		
		
		
		if (keyCode == LEFT)
		{
			index++;
			System.out.println("Printing");
			//error checking code
			if (index == nematodes.size()) {
				index = 0;
			}
		} else if (keyCode == RIGHT)
		{
			index--;
			if(index < 0) {
				index = 0;
			}
		}

		//if pressed R, a random nematode is given

		if (key == 'r' || key == 'R') {

			System.out.println("pressed");

			index = (int) random(nematodes.size()-1);

		}
			
	}

	public void mousePressed() {

		index++;
		System.out.println("Printing");
		//error checking code
		if (index == nematodes.size()) {
			index = 0;
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
		printNematode();			
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

	public void printNematode() 
	{
		for(Nematode n: nematodes) {
			System.out.println(n);
		}
	}


	public void draw()
	{
		background(0);
		fill(map(1, 0 , mouseX, 255, mouseY));
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
		fill(map(0, nematodes.size(), 255, 0, 255), 255, 255);
		text(nematodes.get(index).getName(), width/2,  height/2 - height/3);
		
		

		for(int i = 0; i < nematodes.get(index).getLength(); i++) {

			float x = map(i, 1.7f, nematodes.get(index).getLength(),  height/500, height/2 - height/3);
			noFill();

			circle(width/2, height/2 + x, 100);
			//if has limbs
			if(nematodes.get(i).isLimbs()) {
				line(width/2 + 50, height/2 + x, width/2 + 100, height/2 + x);
				line(width/2 - 50, height/2 + x, width/2 - 100, height/2 + x);
			}

			
		
			if(nematodes.get(i).getGender().equals("m")) 
			{
				
				if (i == nematodes.get(index).getLength() -1) {
					fill(255);
					
					stroke(255,0,225);
					line(width/2, height/2 + x + 50 , width/2, height/2 + x + 100);
					circle(width/2, height/2 + x + 110, 20);
					
				}

			} else if (nematodes.get(i).getGender().equals("f")){

				if (i == nematodes.get(index).getLength() -1) {
				
					strokeWeight(10);
					stroke(255,0,225);
					noFill();
					circle(width/2, height/2 + x, 50);
					
				}

			} else if (nematodes.get(i).getGender().equals("h")) {

				if (i == nematodes.get(index).getLength() -1) {
					fill(255);
					
					stroke(255,0,225);
					line(width/2, height/2 + x + 50 , width/2, height/2 + x + 100);
					circle(width/2, height/2 + x + 110, 20);
					strokeWeight(10);
					stroke(255,0,225);
					noFill();
					circle(width/2, height/2 + x, 50);
						
					
					
				}

			}
			else {
					//nothing drawn
			}

			
		
			if (nematodes.get(index).isEyes() && i == 0) {
				fill(255);
				stroke(255,0,225);
				strokeWeight(8);
				line(width/2 - 50, height/2 +x + -20, width/2 * 0.7f, height/2 +x - 80);
				circle(width/2 * 0.7f, height/2 +x - 80, 20);
				line(width/2 + 50, height/2 +x - 20, width/2 * 1.3f, height/2 +x -80);
				circle(width/2 * 1.3f, height/2 +x - 80, 20);
		
			
			}

		
		}



		fill(255);
	}
}
