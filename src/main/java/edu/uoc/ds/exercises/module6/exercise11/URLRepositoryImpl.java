package edu.uoc.ds.exercises.module6.exercise11;


import edu.uoc.ds.adt.nonlinear.SetAVLImpl;
import edu.uoc.ds.adt.sequential.Set;
import edu.uoc.ds.traversal.Iterator;

public class URLRepositoryImpl implements URLRepository {

    private final Set<String> repository;


    public URLRepositoryImpl() {
        repository = new SetAVLImpl<>();
    }


    public void add(String url) {
        repository.add(url);
    }

    public boolean contains(String url) {
        return repository.contains(url);
    }

    public boolean delete(String url) {
        return repository.delete(url) != null;
    }

    public Iterator<String> values() {
        return repository.values();
    }

}
