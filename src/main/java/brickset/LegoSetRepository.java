package brickset;

import repository.Repository;

import java.util.Comparator;

/**
 * Represents a repository of {@code LegoSet} objects.
 */
public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }


    /**
     * Kiírja az összes lego nevét
     *
     * */
    public void abc() {
        var repository = new LegoSetRepository();
        var lego = repository.getAll();
        lego.stream()
                .map(LegoSet::getName)
                .forEach(System.out::println);
    }

    /**
     *  kiírja az első 10 legtöbb legó számnak a nevét
     * */

    public void First10WithMostPieces(){
        var repository = new LegoSetRepository();
        var lego = repository.getAll();
        lego.stream()
                .sorted(Comparator.comparing(LegoSet::getPieces).reversed())
                .limit(10)
                .map(LegoSet::getName)
                .forEach(System.out::println);
    }

    /**
     *  kiírja azokat a neveket amelyiek 10 karakterből állnak
     * */

    public void PrintNameWith10CharLength(){
        var repository = new LegoSetRepository();
        var legos = repository.getAll();
        legos.stream()
                .map(LegoSet::getName)
                .filter(s -> s.length() == 10)
                .forEach(System.out::println);

    }

    /**
     *  kiírja annak a legonak a darabszamat amelynek darabszáma nagyobb mint a paraméter
     * @param number összehasonlításhoz használt szám
     * */
    public void PrintWithMorePiecesThen(int number){
        var repository = new LegoSetRepository();
        var legos = repository.getAll();
        legos.stream()
                .map(LegoSet::getPieces)
                .filter(s -> s >= number)
                .sorted()
                .forEach(System.out::println);
    }

    /**
     *  kiírja annak a legonak a nevét aminek a neve a megadott szöveggel kezdődik
     * @param first megadott szöveg
     * */
    public void printLegoSettNamesBeginningWith(String first) {
        var repository = new LegoSetRepository();
        var lego = repository.getAll();
        lego.stream()
                .map(LegoSet::getName)
                .filter(name -> name.toLowerCase().startsWith(first))
                .forEach(System.out::println);
    }



    public static void main(String[] args) {
        var repository = new LegoSetRepository();
        //repository.abc();
        //repository.First10WithMostPieces();
        //repository.PrintNameWith10CharLength();
        //repository.PrintWithMorePiecesThen(500);
        //repository.printLegoSettNamesBeginningWith("a");


    }




}
