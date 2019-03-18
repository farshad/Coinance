package ir.coinance.mapper;

import java.util.List;

public interface BaseMapper<E, M> {
    E toEntity(M m);
    M toDto(E e);
    List<E> toEntities(List<M> m);
    List<M> toDtos(List<E> e);
}
