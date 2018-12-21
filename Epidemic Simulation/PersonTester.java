import java.io.*;
import java.util.*;

public class PersonTester
{
  public static void main(String[] args) throws IOException
  {
    File f = new File("baby_names.csv"); 
    Scanner fileScan = new Scanner(f); 
    Scanner keyboard = new Scanner(System.in); 
    Random r = new Random(); 
    String name, sex, year, disease = ""; 
    int pos; 
    double percent; 
    int i = 0; 
    boolean flag = true;

    ArrayList<Baby> babyArray = new ArrayList<Baby>(); 
    ArrayList<Adult> adultArray = new ArrayList<Adult>(); 

    fileScan.useDelimiter(",|\\r?\\n"); 

    fileScan.nextLine();

    System.out.println("Enter a year between 1880 and 2008."); 
    String inputYear = keyboard.next(); 

    while (fileScan.hasNext())
      {
        year = fileScan.next();
        name = fileScan.next();
        name = name.replace("\"", "");
        percent = fileScan.nextDouble();
        sex = fileScan.next();
        sex = sex.replace("\"", "");
        i++;

        if (inputYear.equals(year))
        {
          if (i % 2 == 0)
          {
            flag = true;
          }
          else
          {
            flag = false;
          }

          if (flag == true)
          {
            double randDisease = r.nextDouble();

            if (randDisease <= .3) //returns a random status
            {
              disease = "Susceptible";
            }
            else if (randDisease > .3 && randDisease <=.6)
            {
              disease = "Immune"; //set number of immune babies
            }
            else
            {
              disease = "Infected";
            }

            pos = r.nextInt(200 + 1 + 200) - 200;
            int posy = r.nextInt(50 + 1 + 50) - 50;
            babyArray.add(new Baby(name, disease, pos, posy));
          }
          else
          {
            double randDisease = r.nextDouble();
            if (randDisease > .5) //returns a random status
            {
              disease = "Susceptible";
            }
            else
            {
              disease = "Infected";
            }

            pos = r.nextInt(200 + 1 + 200) - 200;
            int e = r.nextInt(200) + 100;

            adultArray.add(new Adult(name, disease, pos, e));
          }
        }
      } //end of database creation
      String succMsg = String.format("SUCCESS: %d ADULTS %d BABIES", adultArray.size(), babyArray.size());
      System.out.println(succMsg);

      boolean menu = true;

      while (menu == true)
      {
        System.out.println("Enter in 1-4:");
        System.out.println("1. Search for Adult/Baby");
        System.out.println("2. Simulate epidemic");
        System.out.println("3. Clean epidemic");
        System.out.println("4. Exit");
        int response = keyboard.nextInt();

        keyboard.nextLine();

        switch (response)
        {
          case 1:
          {
            System.out.println("Search for baby or adult?");
            String babyAdult = keyboard.next();

            if (babyAdult.equalsIgnoreCase("Baby"))
            {
                System.out.println("Search by name, position, or status?");
                String searchCriteria = keyboard.next();

                if (searchCriteria.equalsIgnoreCase("Name"))
                {
                  System.out.println("Search value:");
                  String searchVal = keyboard.next();

                  for (int j = 0; j < babyArray.size(); j++)
                  {
                    if (searchVal.equalsIgnoreCase(babyArray.get(j).getName()))
                    {
                      System.out.println(babyArray.get(j));
                    }
                  }
                }
                else if (searchCriteria.equalsIgnoreCase("Position"))
                {
                  System.out.println("Search value:");
                  int searchPos = keyboard.nextInt();
                  keyboard.nextLine();

                  for (int j = 0; j < babyArray.size(); j++)
                  {
                    if (searchPos == babyArray.get(j).getPosition())
                    {
                      System.out.println(babyArray.get(j));
                    }
                  }
                }
                else if (searchCriteria.equalsIgnoreCase("Status"))
                {
                  System.out.println("Search value:");
                  String searchVal = keyboard.next();

                  for (int j = 0; j < babyArray.size(); j++)
                  {
                    if (searchVal.equalsIgnoreCase(babyArray.get(j).getStatus()))
                    {
                      System.out.println(babyArray.get(j));
                    }
                  }
                }
                else
                {
                  System.out.println("Error");
                }
            }
            else if (babyAdult.equalsIgnoreCase("Adult"))
            {
              System.out.println("Search by name, position, or status?");
              String searchCriteria = keyboard.next();

              if (searchCriteria.equalsIgnoreCase("Name"))
              {
                System.out.println("Search value:");
                String searchVal = keyboard.next();

                for (int j = 0; j < adultArray.size(); j++)
                {
                  if (searchVal.equalsIgnoreCase(adultArray.get(j).getName()))
                  {
                    System.out.println(adultArray.get(j));
                  }
                }
              }
              else if (searchCriteria.equalsIgnoreCase("Position"))
              {
                System.out.println("Search value:");
                int searchPos = keyboard.nextInt();
                keyboard.nextLine();

                for (int j = 0; j < adultArray.size(); j++)
                {
                  if (searchPos == adultArray.get(j).getPosition())
                  {
                    System.out.println(adultArray.get(j));
                  }
                }
              }
              else if (searchCriteria.equalsIgnoreCase("Status"))
              {
                System.out.println("Search value:");
                String searchVal = keyboard.next();

                for (int j = 0; j < adultArray.size(); j++)
                {
                  if (searchVal.equalsIgnoreCase(adultArray.get(j).getStatus()))
                  {
                    System.out.println(adultArray.get(j));
                  }
                }
              }
              else
              {
                System.out.println("Invalid");
              }
            }
            else
            {
              System.out.println("Error");
            }
            break;
          }
          case 2:
          {
            System.out.println("Days of simulation:");
            int days = keyboard.nextInt();
            int d = 1;

            while (d <= days) //for each day in the simulation
            //compares one baby and one adult to all other adults/babies in each loop
            {
              for (int k = 0; k < adultArray.size(); k++) //for each adult in the array
              {
                Adult a = adultArray.get(k);

                String currentStatusA = a.getStatus();
                int currentEnergy = a.getEnergy();

                if (currentEnergy > 0) //if the adult has enough energy
	              {
                  int move = r.nextInt(1 + 1 + 1) - 1; //left meaning subtracting 1 from position and right meaning adding 1
                  a.setEnergy(a.getEnergy()-1); //change energy
                  a.setPosition(a.getPosition() + move); //change position

                  if (a.getPosition() <= 0) //in case position is out of bounds
	                {
	                   a.setPosition(0);
	                }

                  for (int m = 0; m < adultArray.size(); m++) //loops through all adults to see if same position is occupied
                  {
                    Person a2 = adultArray.get(m); //going backwards from index is unnecessary because comparison would already be made
			              if (a.equals(a2))
			              {
                      //do nothing
			              }

                    else
			              {
				                  if (a.getPosition() == a2.getPosition())
				                  {
					                       if (a.getStatus() == "Infected" && a2.getStatus() == "Susceptible")
					                       {
						                             a2.setStatus("Infected");
					                       }
					                       else if (a.getStatus() == "Susceptible" && a2.getStatus() == "Infected")
					                       {
						                             a.setStatus("Infected");
					                       }
					                       else
					                       {
						                             //nothing
					                       }
				                   }
			                }
                  } //end of looping through all adults

                  for (int n = 0; n < babyArray.size(); n++) //compares adult to babies in position
		              {
			                 Baby bA = babyArray.get(n);

			                 if (a.getPosition() == bA.getPosition())
			                 {
				                     if (a.getStatus() == "Infected" && bA.getStatus() == "Susceptible")
				                     {
					                          bA.setStatus("Infected");
				                     }
				                     else if (a.getStatus() == "Susceptible" && bA.getStatus() == "Infected")
				                     {
					                          a.setStatus("Infected");
				                     }
				                     else
				                     {
					                          //nothing
				                     }
			                 }
		              } //end of comparing adult to babies
	              }
              } //end of adult array

              for (int o = 0; o < babyArray.size(); o++) //for each baby in the array
              {
                Baby b = babyArray.get(o);
                String currentStatusB = b.getStatus();

                int moveLR = r.nextInt(1 + 1 + 1) - 1; //position
		            int moveUD = r.nextInt(1 + 1 + 1) - 1; //posy

                b.setPosition(b.getPosition() + moveLR);
		            b.setPositionY(b.getPositionY() + moveUD);

		            if (b.getPosition() <= 0) //in case position is out of bounds
		            {
			                 b.setPosition(0);
		            }

		            if (b.getPositionY() <= 0) //in case positiony is out of bounds
		            {
			               b.setPositionY(0);
		            }

                for (int p = 0; p < babyArray.size(); p++) //compares baby to each baby in position
		            {
                  Baby b2 = babyArray.get(p);
			            if (b.equals(b2))
			            {
				                //do nothing
			            }
                  else
			            {
				                if (b.getPosition() == b2.getPosition() && b.getPositionY() == b2.getPositionY())
				                {
					                     if (b.getStatus() == "Infected" && b2.getStatus() == "Susceptible")
					                     {
						                           b2.setStatus("Infected");
					                     }
					                     else if (b.getStatus() == "Susceptible" && b2.getStatus() == "Infected")
					                     {
						                           b.setStatus("Infected");
					                     }
					                     else
				                       {
						                           //nothing
					                     }
				                }
			            }
                } //end of baby-to-baby comparison

                for (int q = 0; q < babyArray.size(); q++) //compares baby to all adults' position X
		            {
			               Adult aB = adultArray.get(q);

			               if (b.getPosition() == aB.getPosition())
			               {
				                   if (b.getStatus() == "Infected" && aB.getStatus() == "Susceptible")
				                   {
					                        aB.setStatus("Infected");
				                   }
				                   else if (b.getStatus() == "Susceptible" && aB.getStatus() == "Infected")
				                   {
					                        b.setStatus("Infected");
				                   }
				                   else
				                   {
					                        //nothing
				                   }
			               }
		             } //end of baby-to-adult comparison
              } //end of baby array

              for (int s = 0; s < adultArray.size(); s++) //prints status of all adults
              {
                System.out.println(adultArray.get(s).toString());
              }

              for (int t = 0; t < babyArray.size(); t++) //prints status of all babies
              {
                System.out.println(babyArray.get(t).toString());
              }
              d++;
            }

            break;
          }
          case 3:
          {
            int babySize = babyArray.size();
            int adultSize = adultArray.size();

            for (int u = 0; u < babySize; u++)
            {
              if (u <= babySize * .75)
              {
                babyArray.get(u).setStatus("Susceptible");
              }
              else if (u <= babySize * .85)
              {
                babyArray.get(u).setStatus("Immune");
              }
              else
              {
                babyArray.get(u).setStatus("Infected");
              }
            }

            for (int v = 0; v < adultSize; v++)
            {
              if (v <= adultSize * .75)
              {
                adultArray.get(v).setStatus("Susceptible");
              }
              else
              {
                adultArray.get(v).setStatus("Infected");
              }
            }

            System.out.println("SUCCESS!");
            System.out.println("ADULTS: 70% SUSCEPTIBLE 30% INFECTIOUS");
            System.out.println("BABIES: 75% SUSCEPTIBLE 10% IMMUNE 15% INFECTIOUS");
            break;
          }
          case 4:
          {
            menu = false;
            break;
          }
          default:
          {
            System.out.println("Error");
            menu = false;
            break;
          }
        }
      }
  }
}
