package com.example.presentation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Details が String リストのエラー応答の情報を保持するクラス.
 *
 * @param code        エラーコード
 * @param message     エラーメッセージ
 * @param detailsList エラーの詳細リスト
 */
public record ExceptionHandResponse(
    @JsonProperty("code") String code,
    @JsonProperty("message") String message,
    @JsonProperty("details") List<Details> detailsList
) {

}
