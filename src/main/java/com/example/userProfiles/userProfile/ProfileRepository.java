package com.example.userProfiles.userProfile;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

  //Transforms into SQL
  @Query("SELECT s FROM Profile s WHERE s.userName = ?1")

  Optional<Profile> findByName(String userName);

  List<Profile> findByUserName(String userName);

  Profile findUserByName(String userName);

}
