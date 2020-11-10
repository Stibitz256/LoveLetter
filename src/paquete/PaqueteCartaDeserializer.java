package paquete;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import dominio.entidad.EnumerationCarta;

import java.lang.reflect.Type;

public class PaqueteCartaDeserializer implements JsonDeserializer<PaqueteCarta> {
	public PaqueteCarta deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {

		return new PaqueteCarta(json.getAsJsonObject().get("comando").getAsString(),
				EnumerationCarta.valueOf(json.getAsJsonObject().get("carta").getAsString()));
	}
}
