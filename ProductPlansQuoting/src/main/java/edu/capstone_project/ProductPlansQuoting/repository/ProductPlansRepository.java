package edu.capstone_project.ProductPlansQuoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.capstone_project.ProductPlansQuoting.dto.ProductPlansResponse;
import edu.capstone_project.ProductPlansQuoting.model.ProductPlans;
import jakarta.transaction.Transactional;

import java.util.List;
import edu.capstone_project.ProductPlansQuoting.model.Locations;


public interface ProductPlansRepository extends JpaRepository<ProductPlans, Integer> {
	 @Query(value = "SELECT Distinct productplans.* FROM product_plans productplans " +
             "INNER JOIN product_plans_plan_subscriptions planSubscriptions ON productplans.s_no = planSubscriptions.product_plans_s_no " +
             "INNER JOIN product_plans_plan_locations planLocations ON productplans.s_no = planLocations.product_plans_s_no " +
             "INNER JOIN t_subscriptions subscriptions ON planSubscriptions.plan_subscriptions_sub_id = subscriptions.sub_id " +
             "INNER JOIN t_locations locations ON planLocations.plan_locations_loc_id = locations.loc_Id " +
             "WHERE locations.locations = :locationName " +
             "AND (productplans.plan_category = :category OR :category IS NULL)", nativeQuery = true)
	
	
List<ProductPlans> findProductsByLocationAndCategory(
 @Param("locationName") String locationName,
 @Param("category") String category
);

	 @Modifying
	 @Transactional
	@Query("delete from ProductPlans where planId=?1")
	 void deleteByPlanId(String planId);
	 
//	 @Query("from Product where pname like ?1%")
//	 List<ProductPlans> findByPlanName(String planName);

	
	
}
