package com.ef;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class Parser {
	public static void main(String[] args) {

		Path path = Paths.get(System.getProperty("user.dir"), "/arquivos/access.log");

		Stream<String> lines = null;

		try {
			lines = Files.lines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 2017-01-01 00:00:23.003

		LocalDateTime startDate = LocalDateTime.of(2017, 01, 01, 04, 01, 40, 444);

		LocalDateTime endDate = LocalDateTime.of(2017, 01, 01, 05, 01, 40, 444);

		Stream<String> filtered = lines.filter(f -> {
			return FilterPersonalized.filteringByParams(f, startDate, endDate);
		});

		filtered.forEach(System.out::println);
		
		Map<String, Integer> ips = new HashMap<>();
		
		filtered.forEach(f -> {
			
			String ip = f.split("\\|")[1];
			
			ips.put(f, +1);
			
		});

	}
}
