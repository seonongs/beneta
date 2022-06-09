package io.beneta.member;

import org.springframework.data.geo.GeoResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {


}
