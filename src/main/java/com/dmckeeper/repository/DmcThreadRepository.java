package com.dmckeeper.repository;

import com.dmckeeper.model.DmcThread;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DmcThreadRepository extends JpaRepository<DmcThread, Long> {
}
