package com.hoang2001giang.Libra.book.data;

import com.hoang2001giang.Libra.book.dto.GetBooksInVO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BookSpecification implements Specification<Book>{

    private GetBooksInVO vo;

    public BookSpecification(GetBooksInVO _vo) {
        this.vo = _vo;
    }

    @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (vo == null) return null;
        List<Predicate> predicates = new ArrayList<>();
        if (vo.getName()  != null && !vo.getName().isBlank()) {
            predicates.add(cb.like(root.<String>get("name"), "%" + vo.getName() + "%"));
        }

        if (vo.getDescription()  != null && !vo.getDescription().isBlank()) {
            predicates.add(cb.like(root.<String>get("description"), "%" + vo.getName() + "%"));
        }

        return cb.and(predicates.toArray(new Predicate[0]));
    }
}
