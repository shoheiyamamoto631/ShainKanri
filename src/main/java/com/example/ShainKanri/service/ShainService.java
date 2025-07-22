package com.example.ShainKanri.service;

import java.util.List;

import com.example.ShainKanri.entity.Shain;

public interface ShainService {

	//全社員を取得
	List<Shain> findAll();

	//リクエストから社員オブジェクトを作成
	Shain makeShain(Shain request);

	//社員挿入
	void insertShain(Shain shain);

	//社員IDによる社員取得
	Shain findByShainId(int shainId);

	//社員更新
	void updateShain(Shain shain);

	//社員削除
	void deleteShain(int shainId);

}
