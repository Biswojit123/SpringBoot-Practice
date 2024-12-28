package com.biswo.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.annotations.ListIndexBase;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "STORE_ROOM")
@Data
public class Storeroom {
	@Id
	@GeneratedValue
	private Integer storeRoomNo;
	@Column(length = 30)
	private String nameOfStore;
	@ElementCollection
	@CollectionTable(name = "Items_table", joinColumns = @JoinColumn(name = "storeroom_id", referencedColumnName = "storeRoomNo"))
	@Column(name = "category_Items", length = 30)
	@OrderColumn(name = "items_enter_order")
	@ListIndexBase(1)
	private List<String> categoryOfItems;
	@ElementCollection
	@CollectionTable(name = "Items_Number_table", joinColumns = @JoinColumn(name = "storeroom_id", referencedColumnName = "storeRoomNo"))
	@Column(name = "items_number")
	private Set<Long> itemsNumber;
	@ElementCollection
	@CollectionTable(name = "Items_Its_Price", joinColumns = @JoinColumn(name = "storeroom_id", referencedColumnName = "storeRoomNo"))
	@Column(name = "items_price")
	@MapKeyColumn(name = "Items", length = 30)
	private Map<String, Double> itemsPrice;
}
