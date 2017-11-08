package org.avco.dao;

import java.util.HashMap;
import java.util.Map;

import org.avco.datamodel.Message;
import org.avco.datamodel.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();

	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}

	
	
	
}
