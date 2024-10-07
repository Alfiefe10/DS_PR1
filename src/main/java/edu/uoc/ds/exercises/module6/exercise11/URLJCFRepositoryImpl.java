package edu.uoc.ds.exercises.module6.exercise11;

import java.util.*;

public class URLJCFRepositoryImpl implements URLRepository {
	
	private final Set<String> repository;
	
	
	public URLJCFRepositoryImpl() {
		repository =new HashSet<String>();
	}
	
	
	public void add(String url) { repository.add(url); }
	public boolean contains(String url) { return repository.contains(url); }
	public boolean delete(String url) { return repository.remove(url); }
	public Iterator<String> elementos() { return repository.iterator(); }

}
