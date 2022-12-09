package dao;

import domain.Quality;

public interface QualityDao {
    Quality findQualityByID(int qualityID);
}
