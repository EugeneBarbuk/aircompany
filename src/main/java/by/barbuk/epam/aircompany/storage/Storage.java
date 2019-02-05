package by.barbuk.epam.aircompany.storage;


import java.util.List;

public interface Storage <T> {
    List<T> addPlane(T plane);

}
