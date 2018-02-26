package com.ysrbdlgn.spring.webapp.repository;

import com.ysrbdlgn.spring.webapp.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
