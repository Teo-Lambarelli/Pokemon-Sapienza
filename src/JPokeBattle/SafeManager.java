package JPokeBattle;
import battlemanager.Team; 
import pokemon.*;
import moves.Move;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.reflect.Constructor;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Classe di utilità utilizzata per salvare e caricare le squadre dei giocatori in formato JSON.
 */
public class SafeManager {
	
	/**
     * Metodo statico per salvare una squadra in un file JSON.
     * 
     * @param team La squadra da salvare.
     */
	static public void safeFile(Team team) {
		String name = team.getName();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		
		JSONArray pokemon = new JSONArray();
		for (Pokemon p : team.getArrayTeam()) {
			JSONObject member = new JSONObject();
			member.put("name", p.getName());
			member.put("level", p.getStats().getLvl());
			member.put("xp", p.getStats().getXp());
			
			JSONArray moves = new JSONArray();
			for (Move m : p.getMoves()) {
				if (m != null)
					moves.add(m.toString());
				else
					moves.add(null);
			}
			member.put("moves", moves);
			
			pokemon.add(member);
		}
		jsonObject.put("pokemon", pokemon);
		
		try (FileWriter fileWriter = new FileWriter(name + ".json")) {
            fileWriter.write(jsonObject.toJSONString());
            System.out.println("Team scritto in " + name + ".json");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	 /**
     * Metodo statico per caricare una squadra da un file JSON.
     * 
     * @param name Il nome del file da cui caricare la squadra.
     * @return La squadra caricata.
     */
	static public Team loadFile(String name) {
		ArrayList<Pokemon> team = new ArrayList<Pokemon>();
		
		JSONParser jsonParser = new JSONParser();
		try (FileReader fileReader = new FileReader(name + ".json")) {
            Object obj = jsonParser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obj;
            
            JSONArray pokemon = (JSONArray) jsonObject.get("pokemon");
            
            for (Object memberObj : pokemon) {
            	JSONObject member = (JSONObject) memberObj;
            	
            	Pokemon p = Pokemon.createPokemon((String) member.get("name"), Math.toIntExact((long) member.get("level")));
            	
            	JSONArray moves = (JSONArray) member.get("moves");
            	for (int i = 0; i < moves.size(); i++) {
            		if ((String) moves.get(i) != null) {
            			Move m = Move.toMove((String) moves.get(i));
            			p.setOneMove(m, i);
            		}
            		else {
            			p.setOneMove(null, i);
            		}
            	}
            	p.getStats().setXp((double) member.get("xp"));
            	team.add(p);
            }
            
            Pokemon[] group = new Pokemon[team.size()];
            for (int i = 0; i < team.size(); i++) {
            	group[i] = team.get(i);
            }
            
            Team result = new Team(group, name);
            return result;
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return null;
	}
}
