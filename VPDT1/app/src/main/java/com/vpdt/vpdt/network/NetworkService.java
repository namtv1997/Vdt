package com.vpdt.vpdt.network;

import com.vpdt.vpdt.Token;
import com.vpdt.vpdt.model.*;
import com.vpdt.vpdt.model.Response;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

public interface NetworkService {

    @POST("/token")
    @FormUrlEncoded
    Observable<Token> login(@Field("username") String username,
                            @Field("password") String password,
                            @Field("firebase_token") String firebaseToken,
                            @Field("grant_type") String grantType,
                            @Field("nam") String nam);

    @POST("/token")
    @FormUrlEncoded
    Observable<Token> refreshToken(@Field("refresh_token") String refreshToken,
                                   @Field("grant_type") String grantType);

    @POST("/token")
    @FormUrlEncoded
    Call<Token> refreshToken2(@Field("refresh_token") String refreshToken,
                              @Field("grant_type") String grantType);

    @GET("api/Canbo/getById")
    Observable<Response<CanBo>> getCanBo(@Header("Authorization") String token,
                                         @Query("id") String id,
                                         @Query("nam") String nam);

    @GET("api/Menu/getMenu")
    Observable<Response<ArrayList<Contact>>> getMenu(@Header("Authorization") String token,
                                                     @Query("nam") String nam,
                                                     @Query("id_tk") String id_tk,
                                                     @Query("key") String key,
                                                     @Query("is_right") String is_right);
    @GET("api/Menu/getMenu")
    Call <Response<ArrayList<Contact>>> getMenu1(@Header("Authorization") String token,
                                                          @Query("nam") String nam,
                                                          @Query("id_tk") String id_tk,
                                                          @Query("key") String key,
                                                          @Query("is_right") String is_right);


    @GET("api/Menu/getMenuLeft")
    Observable<Response<ArrayList<MenuLeft>>> getMenuLeft(@Header("Authorization") String token,
                                                          @Query("nam") String nam,
                                                          @Query("id_tk") String id_tk);

    //danh sach van ban da chi dao

    @GET("api/XulyVanBan/getallvblanhdaodachidao")
    Observable<Response<ArrayList<DSVB_DaChiDao>>> getallvblanhdaodachidao(@Header("Authorization") String token,
                                                                           @Query("nam") String nam,
                                                                           @Query("id_tk") String id_tk,
                                                                           @Query("page") int page,
                                                                           @Query("size") int size);

    @GET("api/XulyVanBan/getbyidvblanhdaodachidao")
    Observable<Response<DSVB_DaChiDao>> getbyidvblanhdaodachidao(@Header("Authorization") String token,
                                                                 @Query("id_vb") int id_vb,
                                                                 @Query("id_tk") String id_tk,
                                                                 @Query("nam") String nam);

    @GET("api/XulyVanBan/countvblanhdaodachidao")
    Observable<Response<Integer>> countvblanhdaodachidao(@Header("Authorization") String token,
                                                         @Query("nam") String nam,
                                                         @Query("id_tk") String id_tk);

    @POST("api/XulyVanBan/duyetvbdenLanhdaodachidao")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetvbdenLanhdaodachidao(@Header("Authorization") String token,
                                                            @Field("id_tk") String id_tk,
                                                            @Field("id_vb") int id_vb,
                                                            @Field("id_phogiamdoc") int id_phogiamdoc,
                                                            @Field("id_phongchutri") int id_phongchutri,
                                                            @Field("id_phong_phoihops") String id_phong_phoihops,
                                                            @Field("chidao_phogiamdoc") String chidao_phogiamdoc,
                                                            @Field("chidao_phongchutri") String chidao_phongchutri,
                                                            @Field("phogiamdocthammuu") boolean phogiamdocthammuu,
                                                            @Field("han_giai_quyet") String han_giai_quyet,
                                                            @Field("is_vbquantrong") boolean is_vbquantrong,
                                                            @Field("nam") String nam);

    // PHONG CHU TRI CHO XU LY
    @POST("api/XulyVanBan/duyetVBPhongChuTriChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBPhongChuTriChoXuLy(@Header("Authorization") String token,
                                                            @Field("id") int id,
                                                            @Field("idPhoPhong") int idPhoPhong,
                                                            @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                            @Field("idChuyenVien") int idChuyenVien,
                                                            @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                            @Field("chiDao") String chiDao,
                                                            @Field("chiDaoChuTri") String chiDaoChuTri,
                                                            @Field("luuvanBan") boolean luuvanBan,
                                                            @Field("vanBanQuanTrong") boolean vanBanQuanTrong,
                                                            @Field("phoGiamDocDonDoc") boolean phoGiamDocDonDoc,
                                                            @Field("hanGiaiQuyet") String hanGiaiQuyet,
                                                            @Field("nam") String nam);

    @POST("api/XulyVanBan/tuChoiVBPhongChuTriChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiVBPhongChuTriChoXuLy(@Header("Authorization") String token,
                                                             @Field("id") int id,
                                                             @Field("noiDungTuChoi") String noiDungTuChoi,
                                                             @Field("ghiChu") String ghiChu,
                                                             @Field("nam") String nam);

    @POST("api/XulyVanBan/themHanVBPhongChuTriChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> themHanVBPhongChuTriChoXuLy(@Header("Authorization") String token,
                                                              @Field("id") int id,
                                                              @Field("hanDeXuat") String hanDeXuat,
                                                              @Field("lyDo") String lyDo,
                                                              @Field("nam") String nam);

    @GET("api/XulyVanBan/getAllPhongChuTriChoXuLy")
    Observable<Response<ArrayList<PhongChuTriChoXL>>> getAllPhongChuTriChoXuLy(@Header("Authorization") String token,
                                                                               @Query("nam") String nam,
                                                                               @Query("page") int page,
                                                                               @Query("size") int size);

    @GET("api/XulyVanBan/countAllPhongChuTriChoXuLy")
    Observable<Response<Integer>> coutAllPhongChuTriChoXuLy(@Header("Authorization") String token,
                                                            @Query("nam") String nam);


    //phong chu tri cho xu ly pho phong
    @GET("api/XulyVanBan/getAllChuTriChoXuLy")
    Observable<Response<ArrayList<VanBanChuTriChoXuLy>>> getAllChuTriChoXuLy(@Header("Authorization") String token,
                                                                             @Query("nam") String nam,
                                                                             @Query("page") int page,
                                                                             @Query("size") int size);

    @GET("api/XulyVanBan/countAllChuTriChoXuLy")
    Observable<Response<Integer>> countAllChuTriChoXuLy(@Header("Authorization") String token,
                                                        @Query("nam") String nam);

    @POST("api/XulyVanBan/tuChoiVBChuTriChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiVBChuTriChoXuLy(@Header("Authorization") String token,
                                                        @Field("id") int id,
                                                        @Field("noiDungTuChoi") String noiDungTuChoi,
                                                        @Field("ghiChu") String ghiChu);

    @POST("api/XulyVanBan/themHanVBChuTriChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> themHanVBChuTriChoXuLy(@Header("Authorization") String token,
                                                         @Field("id") int id,
                                                         @Field("hanDeXuat") String hanDeXuat,
                                                         @Field("lyDo") String lyDo,
                                                         @Field("nam") String nam);

    @POST("api/XulyVanBan/duyetVBChuTriChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBChuTriChoXuLy(@Header("Authorization") String token,
                                                       @Field("id") int id,
                                                       @Field("idChuyenVien") int idChuyenVien,
                                                       @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                       @Field("chiDaoChuTri") String chiDaoChuTri,
                                                       @Field("luuvanBan") boolean luuvanBan,
                                                       @Field("phoGiamDocDonDoc") boolean phoGiamDocDonDoc,
                                                       @Field("hanXuLy") String hanXuLy,
                                                       @Field("nam") String nam);

    //PhongChuTriChoXuLyCC
    @GET("api/XulyVanBan/getAllVBPhongChuTriChoXuLyCC")
    Observable<Response<ArrayList<PhongChuTriChoXuLyCC>>> getAllVBPhongChuTriChoXuLyCC(@Header("Authorization") String token,
                                                                                       @Query("nam") String nam,
                                                                                       @Query("page") int page,
                                                                                       @Query("size") int size);

    @GET("api/XulyVanBan/countAllVBPhongChuTriChoXuLyCC")
    Observable<Response<Integer>> countAllVBPhongChuTriChoXuLyCC(@Header("Authorization") String token,
                                                                 @Query("nam") String nam);

    @POST("api/XulyVanBan/duyetVBPhongChuTriChoXuLyCC")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBPhongChuTriChoXuLyCC(@Header("Authorization") String token,
                                                              @Field("nam") String nam,
                                                              @Field("id") int id,
                                                              @Field("idChiCuc") int idChiCuc,
                                                              @Field("idChiCucPho") int idChiCucPho,
                                                              @Field("idTruongPhong") int idTruongPhong,
                                                              @Field("idTruongPhongPPs") String idTruongPhongPPs,
                                                              @Field("chiDaoChiCucPho") String chiDaoChiCucPho,
                                                              @Field("chiDaoChuTri") String chiDaoChuTri,
                                                              @Field("hanGiaiQuyet") String hanGiaiQuyet);

    @POST("api/XulyVanBan/tuChoiVBPhongChuTriChoXuLyCC")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiVBPhongChuTriChoXuLyCC(@Header("Authorization") String token,
                                                               @Field("nam") String nam,
                                                               @Field("id") int id,
                                                               @Field("noiDungTuChoi") String noiDungTuChoi,
                                                               @Field("ghiChu") String ghiChu);

    // VAN BAN CHU TRI CHO XU LY CHUYEN VIEN
    @GET("api/XulyVanBan/getAllChuTriChoXuLyCV")
    Observable<Response<ArrayList<VanBanChuTriChoXuLyChuyenVien>>> getAllChuTriChoXuLyCV(@Header("Authorization") String token,
                                                                                         @Query("nam") String nam,
                                                                                         @Query("page") int page,
                                                                                         @Query("size") int size);

    @GET("api/XulyVanBan/countAllChuTriChoXuLyCV?")
    Observable<Response<Integer>> countAllChuTriChoXuLyCV(@Header("Authorization") String token,
                                                          @Query("nam") String nam);

    @POST("api/XulyVanBan/tuChoiVBChuTriChoXuLyCV")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiVBChuTriChoXuLyCV(@Header("Authorization") String token,
                                                          @Field("id") int id,
                                                          @Field("noiDungTuChoi") String noiDungTuChoi,
                                                          @Field("idCanBoChuyen") int idCanBoChuyen,
                                                          @Field("nam") String nam);

    // van ban pho phong biet de don doc
    @GET("api/XulyVanBan/getAllVBPhoPhongBietDeDonDoc")
    Observable<Response<ArrayList<VanBanPhoPhongBietDeDonDoc>>> getAllVBPhoPhongBietDeDonDoc(@Header("Authorization") String token,
                                                                                             @Query("nam") String nam,
                                                                                             @Query("page") int page,
                                                                                             @Query("size") int size);

    @GET("api/XulyVanBan/countAllVBPhoPhongBietDeDonDoc")
    Observable<Response<Integer>> countAllVBPhoPhongBietDeDonDoc(@Header("Authorization") String token,
                                                                 @Query("nam") String nam);

    //giay moi phong chu tri cho xu ly
    @POST("api/XuLyGiayMoi/duyetGMPhongChuTriChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetGMPhongChuTriChoXuLy(@Header("Authorization") String token,
                                                            @Field("id") int id,
                                                            @Field("idPhoPhong") int idPhoPhong,
                                                            @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                            @Field("idChuyenVien") int idChuyenVien,
                                                            @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                            @Field("chiDao") String chiDao,
                                                            @Field("chiDaoChuTri") String chiDaoChuTri,
                                                            @Field("hanGiaiQuyet") String hanGiaiQuyet,
                                                            @Field("nam") String nam);

    @POST("api/XuLyGiayMoi/tuChoiGMPhongChuTriChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiGMPhongChuTriChoXuLy(@Header("Authorization") String token,
                                                             @Field("id") int id,
                                                             @Field("noiDungTuChoi") String noiDungTuChoi,
                                                             @Field("ghiChu") String ghiChu,
                                                             @Field("nam") String nam);

    @GET("api/XuLyGiayMoi/countAllGMPhongChuTriChoXuLy")
    Observable<Response<Integer>> countAllGMPhongChuTriChoXuLy(@Header("Authorization") String token,
                                                               @Query("nam") String nam);

    @GET("api/XuLyGiayMoi/getAllGMPhongChuTriChoXuLy")
    Observable<Response<ArrayList<GMPhongChuTriChoXuLy>>> getAllGMPhongChuTriChoXuLy(@Header("Authorization") String token,
                                                                                     @Query("nam") String nam,
                                                                                     @Query("page") int page,
                                                                                     @Query("size") int size);

    //giay moi phong phoi hop cho xu ly
    @GET("api/XuLyGiayMoi/getAllGMPhongPhoiHopChoXuLy")
    Observable<Response<ArrayList<GMPhongChuTriChoXuLy>>> getAllGMPhongPhoiHopChoXuLy(@Header("Authorization") String token,
                                                                                      @Query("nam") String nam,
                                                                                      @Query("page") int page,
                                                                                      @Query("size") int size);

    @GET("api/XuLyGiayMoi/countAllGMPhongPhoiHopChoXuLy")
    Observable<Response<Integer>> countAllGMPhongPhoiHopChoXuLy(@Header("Authorization") String token,
                                                                @Query("nam") String nam);

    @POST("api/XuLyGiayMoi/duyetGMPhongPhoiHopChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetGMPhongPhoiHopChoXuLy(@Header("Authorization") String token,
                                                             @Field("id") int id,
                                                             @Field("idPhoPhong") int idPhoPhong,
                                                             @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                             @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                             @Field("chiDao") String chiDao,
                                                             @Field("chiDaoChuTri") String chiDaoChuTri,
                                                             @Field("hanGiaiQuyet") String hanGiaiQuyet,
                                                             @Field("nam") String nam);

    @POST("api/XuLyGiayMoi/tuChoiGMPhoiHopChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiGMPhoiHopChoXuLy(@Header("Authorization") String token,
                                                         @Field("idPhoiHop") int idPhoiHop,
                                                         @Field("noiDungTuChoi") String noiDungTuChoi,
                                                         @Field("nam") String nam);

    //giay moi phoi hop da chi dao
    @POST("api/XuLyGiayMoi/duyetGMGiaoPhongPhoiHopDaChiDao")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetGMGiaoPhongPhoiHopDaChiDao(@Header("Authorization") String token,
                                                                  @Field("id") int id,
                                                                  @Field("idPhoPhong") int idPhoPhong,
                                                                  @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                                  @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                  @Field("chiDao") String chiDao,
                                                                  @Field("chiDaoChuTri") String chiDaoChuTri,
                                                                  @Field("hanGiaiQuyet") String hanGiaiQuyet,
                                                                  @Field("nam") String nam);

    @POST("api/XuLyGiayMoi/tuChoiGMPhoiHopDaChiDao")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiGMPhoiHopDaChiDao(@Header("Authorization") String token,
                                                          @Field("idPhoiHop") int idPhoiHop,
                                                          @Field("noiDungTuChoi") String noiDungTuChoi,
                                                          @Field("nam") String nam);

    //giay moi pho phong phoi hop cho xu ly
    @GET("api/XuLyGiayMoi/getAllGMPhoPhongPhoiHopChoXuLy")
    Observable<Response<ArrayList<GiayMoiPhongPhoiHopChoXuLy>>> getAllGMPhoPhongPhoiHopChoXuLy(@Header("Authorization") String token,
                                                                                               @Query("nam") String nam,
                                                                                               @Query("page") int page,
                                                                                               @Query("size") int size);

    @GET("api/XuLyGiayMoi/countAllGMPhoPhongPhoiHopChoXuLy")
    Observable<Response<Integer>> countAllGMPhoPhongPhoiHopChoXuLy(@Header("Authorization") String token,
                                                                   @Query("nam") String nam);

    @POST("api/XuLyGiayMoi/duyetGMPhoPhongPhoiHopChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetGMPhoPhongPhoiHopChoXuLy(@Header("Authorization") String token,
                                                                @Field("id") int id,
                                                                @Field("idPhoPhong") int idPhoPhong,
                                                                @Field("idPhoiHop") int idPhoiHop,
                                                                @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                @Field("chiDaoChuTri") String chiDaoChuTri,
                                                                @Field("hanXuLy") String hanXuLy,
                                                                @Field("nam") String nam);

    //giay moi chu tri cho xu ly chuyen vien
    @GET("api/XuLyGiayMoi/getAllGMChuTriChoXuLyCV")
    Observable<Response<ArrayList<GiayMoiGiaoChuTriChoXuLy>>> getAllGMChuTriChoXuLyCV(@Header("Authorization") String token,
                                                                                      @Query("nam") String nam,
                                                                                      @Query("page") int page,
                                                                                      @Query("size") int size);

    @GET("api/XuLyGiayMoi/countAllGMChuTriChoXuLyCV")
    Observable<Response<Integer>> countAllGMChuTriChoXuLyCV(@Header("Authorization") String token,
                                                            @Query("nam") String nam);

    @POST("api/XuLyGiayMoi/tuChoiGMChuTriChoXuLyCV")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiGMChuTriChoXuLyCV(@Header("Authorization") String token,
                                                          @Field("id") int id,
                                                          @Field("noiDungTuChoi") String noiDungTuChoi,
                                                          @Field("idCanBoChuyen") int idCanBoChuyen,
                                                          @Field("nam") String nam);

    //giay moi chu tri cho xu ly
    @GET("api/XuLyGiayMoi/getAllGMChuTriChoXuLy")
    Observable<Response<ArrayList<GiayMoiChuTriChoXuLy>>> getAllGMChuTriChoXuLy(@Header("Authorization") String token,
                                                                                @Query("nam") String nam,
                                                                                @Query("page") int page,
                                                                                @Query("size") int size);

    @GET("api/XuLyGiayMoi/countAllGMChuTriChoXuLy")
    Observable<Response<Integer>> countAllGMChuTriChoXuLy(@Header("Authorization") String token,
                                                          @Query("nam") String nam);

    @POST("api/XuLyGiayMoi/duyetGMChuTriChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetGMChuTriChoXuLy(@Header("Authorization") String token,
                                                       @Field("id") int id,
                                                       @Field("idChuyenVien") int idChuyenVien,
                                                       @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                       @Field("chiDaoChuTri") String chiDaoChuTri,
                                                       @Field("hanXuLy") String hanXuLy);

    @POST("api/XuLyGiayMoi/tuChoiGMChuTriChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiGMChuTriChoXuLy(@Header("Authorization") String token,
                                                        @Field("id") int id,
                                                        @Field("noiDungTuChoi") String noiDungTuChoi,
                                                        @Field("ghiChu") String ghiChu);

    // giay moi phong chu tri da hoan thanh
    @GET("api/XuLyGiayMoi/countAllGMGiaoPhongChuTriDaHoanThanh")
    Observable<Response<Integer>> countAllGMGiaoPhongChuTriDaHoanThanh(@Header("Authorization") String token,
                                                                       @Query("nam") String nam);

    @GET("api/XuLyGiayMoi/getAllGMGiaoPhongChuTriDaHoanThanh")
    Observable<Response<ArrayList<GMPhongChuTriDaHoanThanh>>> getAllGMGiaoPhongChuTriDaHoanThanh(@Header("Authorization") String token,
                                                                                                 @Query("nam") String nam,
                                                                                                 @Query("page") int page,
                                                                                                 @Query("size") int size);

    @POST("api/XuLyGiayMoi/duyetGMGiaoPhongChuTriDaHoanThanh")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetGMGiaoPhongChuTriDaHoanThanh(@Header("Authorization") String token,
                                                                    @Field("id") int id,
                                                                    @Field("idPhoPhong") int idPhoPhong,
                                                                    @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                                    @Field("idChuyenVien") int idChuyenVien,
                                                                    @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                    @Field("chiDao") String chiDao,
                                                                    @Field("chiDaoChuTri") String chiDaoChuTri,
                                                                    @Field("hanGiaiQuyet") String hanGiaiQuyet,
                                                                    @Field("nam") String nam);


    //giay moi phong chu tri da chi dao
    @GET("api/XuLyGiayMoi/getAllGMGiaoPhongChuTriDaChiDao")
    Observable<Response<ArrayList<GMPhongChuTriDaChiDao>>> getAllGMGiaoPhongChuTriDaChiDao(@Header("Authorization") String token,
                                                                                           @Query("nam") String nam,
                                                                                           @Query("page") int page,
                                                                                           @Query("size") int size);

    @GET("api/XuLyGiayMoi/countAllGMGiaoPhongChuTriDaChiDao")
    Observable<Response<Integer>> countAllGMGiaoPhongChuTriDaChiDao(@Header("Authorization") String token,
                                                                    @Query("nam") String nam);

    @POST("api/XuLyGiayMoi/duyetGMGiaoPhongChuTriDaChiDao")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetGMGiaoPhongChuTriDaChiDao(@Header("Authorization") String token,
                                                                 @Field("id") int id,
                                                                 @Field("idPhoPhong") int idPhoPhong,
                                                                 @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                                 @Field("idChuyenVien") int idChuyenVien,
                                                                 @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                 @Field("chiDao") String chiDao,
                                                                 @Field("chiDaoChuTri") String chiDaoChuTri,
                                                                 @Field("vanBanQuanTrong") boolean vanBanQuanTrong,
                                                                 @Field("hanGiaiQuyet") String hanGiaiQuyet,
                                                                 @Field("nam") String nam);

    // VAN BAN DA DE XUAT GIA HAN GIAI QUYET  3: bị từ chối | 2 : gia hạn thành công | 1 : đang chờ lãnh đạo duyệt
    @GET("api/XulyVanBan/getAllVBDaDeXuatGiaHanGiaQuyet")
    Observable<Response<ArrayList<VanBanDaDeXuatGiaHanGiaiQuyet>>> getAllVBDaDeXuatGiaHanGiaQuyet(@Header("Authorization") String token,
                                                                                                  @Query("nam") String nam,
                                                                                                  @Query("page") int page,
                                                                                                  @Query("size") int size);

    @GET("api/XulyVanBan/countAllVBDaDeXuatGiaHanGiaQuyet")
    Observable<Response<Integer>> countAllVBDaDeXuatGiaHanGiaQuyet(@Header("Authorization") String token,
                                                                   @Query("nam") String nam);

    @POST("api/XulyVanBan/themHanVBDaDeXuatGiaHanGiaQuyet")
    @FormUrlEncoded
    Observable<Response<Boolean>> themHanVBDaDeXuatGiaHanGiaQuyet(@Header("Authorization") String token,
                                                                  @Field("id") int id,
                                                                  @Field("hanDeXuat") String hanDeXuat,
                                                                  @Field("lyDo") String lyDo,
                                                                  @Field("nam") String nam);

    //de xuat cong viec phoi hop cho duyet
    @GET("api/XulyVanBan/getAllDeXuatCVChoDuyet")
    Observable<Response<ArrayList<DeXuatCongViecPhoiHopChoDuyet>>> getAllDeXuatCVChoDuyet(@Header("Authorization") String token,
                                                                                          @Query("nam") String nam,
                                                                                          @Query("page") int page,
                                                                                          @Query("size") int size);

    @GET("api/XulyVanBan/countAllDeXuatCVChoDuyet")
    Observable<Response<Integer>> countAllDeXuatCVChoDuyet(@Header("Authorization") String token,
                                                           @Query("nam") String nam);

    @POST("api/XulyVanBan/guiLenDeXuatCV")
    @FormUrlEncoded
    Observable<Response<Boolean>> guiLenDeXuatCV(@Header("Authorization") String token,
                                                 @Field("idVB") int idVB,
                                                 @Field("IdPhongPhoiHop") int IdPhongPhoiHop,
                                                 @Field("yKien") String yKien,
                                                 @Field("urlFileYeuCau") String urlFileYeuCau,
                                                 @Field("nam") String nam);

    @POST("api/XulyVanBan/dongYDeXuatCV")
    @FormUrlEncoded
    Observable<Response<Boolean>> dongYDeXuatCV(@Header("Authorization") String token,
                                                @Field("idVB") int idVB,
                                                @Field("IdPhongPhoiHop") int IdPhongPhoiHop,
                                                @Field("nam") String nam);

    @POST("api/XulyVanBan/traLaiDeXuatCV")
    @FormUrlEncoded
    Observable<Response<Boolean>> traLaiDeXuatCV(@Header("Authorization") String token,
                                                 @Field("idVB") int idVB,
                                                 @Field("IdPhongPhoiHop") int IdPhongPhoiHop,
                                                 @Field("yKien") String yKien,
                                                 @Field("urlFileYeuCau") String urlFileYeuCau,
                                                 @Field("nam") String nam);

    // phan loai van ban
    //1: quan trong | 2 k quan trong
    @GET("api/XulyVanBan/getAllVanBanChuaPhanLoai")
    Observable<Response<ArrayList<PhanLoaiVanBan>>> getAllVanBanChuaPhanLoai(@Header("Authorization") String token,
                                                                             @Query("nam") String nam,
                                                                             @Query("page") int page,
                                                                             @Query("size") int size);

    @GET("api/XulyVanBan/countAllVanBanChuaPhanLoai")
    Observable<Response<Integer>> countAllVanBanChuaPhanLoai(@Header("Authorization") String token,
                                                             @Query("nam") String nam);

    @POST("api/XulyVanBan/themNoidungVBChuaPhanLoai")
    @FormUrlEncoded
    Observable<Response<Boolean>> themNoidungVBChuaPhanLoai(@Header("Authorization") String token,
                                                            @Field("id") int id,
                                                            @Field("hanNoiDung") String hanNoiDung,
                                                            @Field("noiDung") String noiDung,
                                                            @Field("nam") String nam);

    @POST("api/XulyVanBan/duyetVBChuaPhanLoai")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBChuaPhanLoai(@Header("Authorization") String token,
                                                      @Field("id") int id,
                                                      @Field("idGiamDoc") int idGiamDoc,
                                                      @Field("idPhoGiamDoc") int idPhoGiamDoc,
                                                      @Field("idPhongChuTri") int idPhongChuTri,
                                                      @Field("hanGiaiQuyet") String hanGiaiQuyet,
                                                      @Field("idPhongPhoiHop") String idPhongPhoiHop,
                                                      @Field("chiDaoGiamDoc") String chiDaoGiamDoc,
                                                      @Field("chiDaoPhoGiamDoc") String chiDaoPhoGiamDoc,
                                                      @Field("chiChuTri") String chiChuTri,
                                                      @Field("isVBQT") int isVBQT,
                                                      @Field("nam") String nam);

    // van ban da phan loai
    //1: quan trong | 2 k quan trong
    @GET("api/XulyVanBan/getAllVanBanDaPhanLoai")
    Observable<Response<ArrayList<VanBanDaPhanLoai>>> getAllVanBanDaPhanLoai(@Header("Authorization") String token,
                                                                             @Query("nam") String nam,
                                                                             @Query("page") int page,
                                                                             @Query("size") int size);

    @GET("api/XulyVanBan/countAllVanBanDaPhanLoai")
    Observable<Response<Integer>> countAllVanBanDaPhanLoai(@Header("Authorization") String token,
                                                           @Query("nam") String nam);

    @POST("api/XulyVanBan/duyetVanBanDaPhanLoai")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVanBanDaPhanLoai(@Header("Authorization") String token,
                                                        @Field("id") int id,
                                                        @Field("idGiamDoc") int idGiamDoc,
                                                        @Field("idPhoGiamDoc") int idPhoGiamDoc,
                                                        @Field("idPhongChuTri") int idPhongChuTri,
                                                        @Field("hanGiaiQuyet") String hanGiaiQuyet,
                                                        @Field("idPhongPhoiHop") String idPhongPhoiHop,
                                                        @Field("chiDaoGiamDoc") String chiDaoGiamDoc,
                                                        @Field("chiDaoPhoGiamDoc") String chiDaoPhoGiamDoc,
                                                        @Field("chiChuTri") String chiChuTri,
                                                        @Field("isVBQT") int isVBQT,
                                                        @Field("nam") String nam);

    //cong viec phoi hop cho xu ly
    @POST("api/XulyVanBan/guiLenCVPhoiHopChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> guiLenCVPhoiHopChoXuLy(@Header("Authorization") String token,
                                                         @Field("idVB") int idVB,
                                                         @Field("IdPhongPhoiHop") int IdPhongPhoiHop,
                                                         @Field("IdCBGiaQuyet") int IdCBGiaQuyet,
                                                         @Field("yKien") String yKien,
                                                         @Field("urlFileYeuCau") String urlFileYeuCau,
                                                         @Field("nam") String nam);

    @POST("api/XulyVanBan/dongYCVPhoiHopChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> dongYCVPhoiHopChoXuLy(@Header("Authorization") String token,
                                                        @Field("idVB") int idVB,
                                                        @Field("IdPhongPhoiHop") int IdPhongPhoiHop,
                                                        @Field("yKien") String yKien,
                                                        @Field("urlFileTraLoi") String urlFileTraLoi,
                                                        @Field("urlFileYeuCau") String urlFileYeuCau,
                                                        @Field("nam") String nam);

    @POST("api/XulyVanBan/traLaiCVPhoiHopChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> traLaiCVPhoiHopChoXuLy(@Header("Authorization") String token,
                                                         @Field("idVB") int idVB,
                                                         @Field("IdPhongPhoiHop") int IdPhongPhoiHop,
                                                         @Field("yKien") String yKien,
                                                         @Field("urlFileYeuCau") String urlFileYeuCau,
                                                         @Field("nam") String nam);


    //so luong van ban giao phong chu tri
    //type tu choi :0: không cho phép từ chối | 1 Call Api Từ chối | 2: Call API Từ chối trưởng phòng

    @GET("api/XulyVanBan/getAllVBGiaoPhongChuTri")
    Observable<Response<ArrayList<SoLuongVanBanGiaoPhongChuTri>>> getAllVBGiaoPhongChuTri(@Header("Authorization") String token,
                                                                                          @Query("nam") String nam,
                                                                                          @Query("page") int page,
                                                                                          @Query("size") int size);

    @GET("api/XulyVanBan/countAllVBGiaoPhongChuTri")
    Observable<Response<Integer>> countAllVBGiaoPhongChuTri(@Header("Authorization") String token,
                                                            @Query("nam") String nam);

    @POST("api/XulyVanBan/tuChoiVBGiaoPhongChuTri")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiVBGiaoPhongChuTri(@Header("Authorization") String token,
                                                          @Field("id") int id,
                                                          @Field("noiDungTuChoi") String noiDungTuChoi,
                                                          @Field("ghiChu") String ghiChu,
                                                          @Field("nam") String nam);

    @POST("api/XulyVanBan/tuChoiVBGiaoPhongChuTriTruongPhong")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiVBGiaoPhongChuTriTruongPhong(@Header("Authorization") String token,
                                                                     @Field("id") int id,
                                                                     @Field("noiDungTuChoi") String noiDungTuChoi,
                                                                     @Field("ghiChu") String ghiChu,
                                                                     @Field("nam") String nam);


    //giay moi da xu ly
    @GET("api/XuLyGiayMoi/getAllGMDaGiaiQuyet")
    Observable<Response<ArrayList<GiayMoiDaXuLy>>> getAllGMDaGiaiQuyet(@Header("Authorization") String token,
                                                                       @Query("nam") String nam,
                                                                       @Query("page") int page,
                                                                       @Query("size") int size);

    @GET("api/XuLyGiayMoi/countAllGMDaGiaiQuyet")
    Observable<Response<Integer>> countAllGMDaGiaiQuyet(@Header("Authorization") String token,
                                                        @Query("nam") String nam);

    //giay moi da phan loai
    @GET("api/XuLyGiayMoi/getAllGMDaPhanLoai")
    Observable<Response<ArrayList<GiayMoiDaPhanLoai>>> getAllGMDaPhanLoai(@Header("Authorization") String token,
                                                                          @Query("nam") String nam,
                                                                          @Query("page") int page,
                                                                          @Query("size") int size);

    @GET("api/XuLyGiayMoi/countAllGMDaPhanLoai")
    Observable<Response<Integer>> countAllGMDaPhanLoai(@Header("Authorization") String token,
                                                       @Query("nam") String nam);

    @POST("api/XuLyGiayMoi/duyetGMDaPhanLoai")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetGMDaPhanLoai(@Header("Authorization") String token,
                                                    @Field("id") int id,
                                                    @Field("idGiamDoc") int idGiamDoc,
                                                    @Field("idPhoGiamDoc") int idPhoGiamDoc,
                                                    @Field("idPhongChuTri") int idPhongChuTri,
                                                    @Field("hanGiaiQuyet") String hanGiaiQuyet,
                                                    @Field("idPhongPhoiHop") String idPhongPhoiHop,
                                                    @Field("chiDaoGiamDoc") String chiDaoGiamDoc,
                                                    @Field("chiDaoPhoGiamDoc") String chiDaoPhoGiamDoc,
                                                    @Field("chiChuTri") String chiChuTri,
                                                    @Field("giamDocDuHop") int giamDocDuHop,
                                                    @Field("PhongDuHop") int PhongDuHop,
                                                    @Field("nam") String nam);


    // van ban giao phong phoi hop
    @GET("api/XulyVanBan/getAllVBPhongPhoiHop")
    Observable<Response<ArrayList<SoLuongVanBanGiaoPhongPhoiHop>>> getAllVBPhongPhoiHop(@Header("Authorization") String token,
                                                                                        @Query("nam") String nam,
                                                                                        @Query("page") int page,
                                                                                        @Query("size") int size);

    @GET("api/XulyVanBan/countAllVBPhongPhoiHop")
    Observable<Response<Integer>> countAllVBPhongPhoiHop(@Header("Authorization") String token,
                                                         @Query("nam") String nam);

    //van ban nguoi dung xu ly
    @GET("api/XulyVanBan/getAllVBNguoiDungXuLy")
    Observable<Response<ArrayList<VanBanNguoiDungXuLy>>> getAllVBNguoiDungXuLy(@Header("Authorization") String token,
                                                                               @Query("nam") String nam,
                                                                               @Query("page") int page,
                                                                               @Query("size") int size);

    @GET("api/XulyVanBan/countAllVBNguoiDungXuLy")
    Observable<Response<Integer>> countAllVBNguoiDungXuLy(@Header("Authorization") String token,
                                                          @Query("nam") String nam);

    @POST("api/XulyVanBan/traLaiVBNguoiDungXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> traLaiVBNguoiDungXuLy(@Header("Authorization") String token,
                                                        @Field("id") int id,
                                                        @Field("noiDungTraLai") String noiDungTraLai,
                                                        @Field("ngayGiaiQuyet") String ngayGiaiQuyet,
                                                        @Field("nam") String nam);

    // giay moi chua phan loai
    @GET("api/XuLyGiayMoi/getAllGMChuaPhanLoai")
    Observable<Response<ArrayList<VanBanNguoiDungXuLy>>> getAllGMChuaPhanLoai(@Header("Authorization") String token,
                                                                              @Query("nam") String nam,
                                                                              @Query("page") int page,
                                                                              @Query("size") int size);

    @GET("api/XuLyGiayMoi/countAllGMChuaPhanLoai")
    Observable<Response<Integer>> countAllGMChuaPhanLoai(@Header("Authorization") String token,
                                                         @Query("nam") String nam);

    @POST("api/XuLyGiayMoi/themNoidungGMChuaPhanLoai")
    @FormUrlEncoded
    Observable<Response<Boolean>> themNoidungGMChuaPhanLoai(@Header("Authorization") String token,
                                                            @Field("id") int id,
                                                            @Field("noiDung") String noiDung,
                                                            @Field("ngayHop") String ngayHop,
                                                            @Field("gioHop") String gioHop,
                                                            @Field("diaDiem") String diaDiem,
                                                            @Field("nam") String nam);

    @POST("api/XuLyGiayMoi/duyetGMChuaPhanLoai")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetGMChuaPhanLoai(@Header("Authorization") String token,
                                                      @Field("id") int id,
                                                      @Field("idGiamDoc") int idGiamDoc,
                                                      @Field("idPhoGiamDoc") int idPhoGiamDoc,
                                                      @Field("idPhongChuTri") int idPhongChuTri,
                                                      @Field("hanGiaiQuyet") String hanGiaiQuyet,
                                                      @Field("idPhongPhoiHop") String idPhongPhoiHop,
                                                      @Field("chiDaoGiamDoc") String chiDaoGiamDoc,
                                                      @Field("chiDaoPhoGiamDoc") String chiDaoPhoGiamDoc,
                                                      @Field("chiChuTri") String chiChuTri,
                                                      @Field("giamDocDuHop") int giamDocDuHop,
                                                      @Field("PhongDuHop") int PhongDuHop,
                                                      @Field("nam") String nam);

    //van ban nguoi dung phoi hop xu ly
    @GET("api/XulyVanBan/getAllVBNguoiDungPhoiHopXuLy")
    Observable<Response<ArrayList<VanBanNguoiDungPhoiHopXuLy>>> getAllVBNguoiDungPhoiHopXuLy(@Header("Authorization") String token,
                                                                                             @Query("nam") String nam,
                                                                                             @Query("page") int page,
                                                                                             @Query("size") int size);

    @GET("api/XulyVanBan/countAllVBNguoiDungPhoiHopXuLy")
    Observable<Response<Integer>> countAllVBNguoiDungPhoiHopXuLy(@Header("Authorization") String token,
                                                                 @Query("nam") String nam);

    // duyet van ban phong phoi hop cho xu ly
    @POST("api/XulyVanBan/duyetVBPhongPhoiHopChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBPhongPhoiHopChoXuLy(@Header("Authorization") String token,
                                                             @Field("id") int id,
                                                             @Field("idPhoPhong") int idPhoPhong,
                                                             @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                             @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                             @Field("chiDao") String chiDao,
                                                             @Field("chiDaoChuTri") String chiDaoChuTri,
                                                             @Field("phoGiamDocDonDoc") boolean phoGiamDocDonDoc,
                                                             @Field("hanGiaiQuyet") String hanGiaiQuyet,
                                                             @Field("nam") String nam);

    @POST("api/XulyVanBan/tuChoiVBPhoiHopChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiVBPhoiHopChoXuLy(@Header("Authorization") String token,
                                                         @Field("idPhoiHop") String idPhoiHop,
                                                         @Field("noiDungTuChoi") String noiDungTuChoi,
                                                         @Field("nam") String nam);

    //GET VAN BAN GIA HAN GIAI QUYET

    @GET("api/XulyVanBan/getallvbgiahangiaquyet")
    Observable<Response<ArrayList<GiaHanGiaiQuyet>>> getallvbgiahangiaquyet(@Header("Authorization") String token,
                                                                            @Query("nam") String nam,
                                                                            @Query("id_tk") String id_tk,
                                                                            @Query("page") int page,
                                                                            @Query("size") int size);

    @GET("api/XulyVanBan/countvbgiahangiaquyet")
    Observable<Response<Integer>> countvbgiahangiaquyet(@Header("Authorization") String token,
                                                        @Query("nam") String nam,
                                                        @Query("id_tk") String id_tk);

    @GET("api/XulyVanBan/getbyidvbgiahangiaquyet")
    Observable<Response<DetailVanBanQuahan>> getbyidvbgiahangiaquyet(@Header("Authorization") String token,
                                                                     @Query("id_vb") int id_vb,
                                                                     @Query("id_tk") String id_tk,
                                                                     @Query("nam") String nam);

    @POST("api/XulyVanBan/tuchoihangiaiquetvanban")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuchoihangiaiquetvanban(@Header("Authorization") String token,
                                                          @Field("id_tk") String id_tk,
                                                          @Field("id_vb") int id_vb,
                                                          @Field("ly_do") String ly_do,
                                                          @Field("nam") String nam);

    @POST("api/XulyVanBan/duyetvbgiahangiaquyet")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetvbgiahangiaquyet(@Header("Authorization") String token,
                                                        @Field("id_tk") String id_tk,
                                                        @Field("id_vb") int id_vb,
                                                        @Field("handexuat") String handexuat,
                                                        @Field("nam") String nam);

    //get van ban stc phoi hop dachi dao

    @GET("api/XulyVanBan/getallvbstcphoihopdachidao")
    Observable<Response<ArrayList<DSVB_DaChiDao>>> getallvbstcphoihopdachidao(@Header("Authorization") String token,
                                                                              @Query("nam") String nam,
                                                                              @Query("id_tk") String id_tk,
                                                                              @Query("page") int page,
                                                                              @Query("size") int size);

    @GET("api/XulyVanBan/getbyidvbstcphoihopdachidao")
    Observable<Response<DSVB_DaChiDao>> getbyidvbstcphoihopdachidao(@Header("Authorization") String token,
                                                                    @Query("id_vb") int id_vb,
                                                                    @Query("id_tk") String id_tk,
                                                                    @Query("nam") String nam);

    @GET("api/XulyVanBan/countvbstcphoihopdachidao")
    Observable<Response<Integer>> countvbstcphoihopdachidao(@Header("Authorization") String token,
                                                            @Query("nam") String nam,
                                                            @Query("id_tk") String id_tk);


    @POST("api/XulyVanBan/duyetvbstcphoihopdachidao")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetvbstcphoihopdachidao(@Header("Authorization") String token,
                                                            @Field("id_tk") String id_tk,
                                                            @Field("id_vb") int id_vb,
                                                            @Field("id_phogiamdoc") int id_phogiamdoc,
                                                            @Field("id_phongchutri") int id_phongchutri,
                                                            @Field("id_phong_phoihops") String id_phong_phoihops,
                                                            @Field("chidao_phogiamdoc") String chidao_phogiamdoc,
                                                            @Field("chidao_phongchutri") String chidao_phongchutri,
                                                            @Field("phogiamdocthammuu") boolean phogiamdocthammuu,
                                                            @Field("han_giai_quyet") String han_giai_quyet,
                                                            @Field("is_vbquantrong") boolean is_vbquantrong,
                                                            @Field("nam") String nam);

    //danh sach van ban den cho xu ly

    @GET("api/XulyVanBan/getallvbdenchoxuly")
    Observable<Response<ArrayList<VanBanDenChoXuLy>>> getallvbdenchoxuly(@Header("Authorization") String token,
                                                                         @Query("nam") String nam,
                                                                         @Query("id_tk") String id_tk,
                                                                         @Query("page") int page,
                                                                         @Query("size") int size);


    @GET("api/XulyVanBan/getbyidvbdenchoxuly")
    Observable<Response<VanBanDenChoXuLy>> getbyidvbdenchoxuly(@Header("Authorization") String token,
                                                               @Query("id_vb") int id_vb,
                                                               @Query("id_tk") String id_tk,
                                                               @Query("nam") String nam);

    @GET("api/XulyVanBan/countvbdenchoxuly")
    Observable<Response<Integer>> countvbdenchoxuly(@Header("Authorization") String token,
                                                    @Query("nam") String nam,
                                                    @Query("id_tk") String id_tk);


    // phong chu tri da chi dao

    @GET("api/XulyVanBan/getAllVBPhongChuTriDaChiDao")
    Observable<Response<ArrayList<PhongChuTriDaChiDao>>> getAllVBPhongChuTriDaChiDao(@Header("Authorization") String token,
                                                                                     @Query("nam") String nam,
                                                                                     @Query("page") int page,
                                                                                     @Query("size") int size);

    @GET("api/XulyVanBan/countAllVBPhongChuTriDaChiDao")
    Observable<Response<Integer>> countAllVBPhongChuTriDaChiDao(@Header("Authorization") String token,
                                                                @Query("nam") String nam);

    @POST("api/XulyVanBan/duyetVBPhongChuTriDaChiDao")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBPhongChuTriDaChiDao(@Header("Authorization") String token,
                                                             @Field("id") int id,
                                                             @Field("idPhoPhong") int idPhoPhong,
                                                             @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                             @Field("idChuyenVien") int idChuyenVien,
                                                             @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                             @Field("chiDao") String chiDao,
                                                             @Field("chiDaoChuTri") String chiDaoChuTri,
                                                             @Field("vanBanDauRaTruongPhong") String vanBanDauRaTruongPhong,
                                                             @Field("vanBanQuanTrong") boolean vanBanQuanTrong,
                                                             @Field("phoGiamDocDonDoc") boolean phoGiamDocDonDoc,
                                                             @Field("hanGiaiQuyet") String hanGiaiQuyet,
                                                             @Field("nam") String nam);

    //van ban phoi hop tra lai

    @GET("api/XulyVanBan/getAllVBPhoiHopTraLai")
    Observable<Response<ArrayList<VanBanPhoiHopTraLai>>> getAllVBPhoiHopTraLai(@Header("Authorization") String token,
                                                                               @Query("nam") String nam,
                                                                               @Query("page") int page,
                                                                               @Query("size") int size);

    @GET("api/XulyVanBan/countAllVBPhoiHopTraLai")
    Observable<Response<Integer>> countAllVBPhoiHopTraLai(@Header("Authorization") String token,
                                                          @Query("nam") String nam);

    @POST("api/XulyVanBan/duyetVBPhoiHopTraLai")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBPhoiHopTraLai(@Header("Authorization") String token,
                                                       @Field("id") int id,
                                                       @Field("idPhoPhong") int idPhoPhong,
                                                       @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                       @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                       @Field("chiDao") String chiDao,
                                                       @Field("chiDaoChuTri") String chiDaoChuTri,
                                                       @Field("phoGiamDocDonDoc") boolean phoGiamDocDonDoc,
                                                       @Field("hanGiaiQuyet") String hanGiaiQuyet,
                                                       @Field("idCanBoTuchoi") int idCanBoTuchoi,
                                                       @Field("nam") String nam);

    //giay moi phoi hop tra lai
    @GET(" api/XuLyGiayMoi/getAllGMPhoiHopTraLai")
    Observable<Response<ArrayList<VanBanPhoiHopTraLai>>> getAllGMPhoiHopTraLai(@Header("Authorization") String token,
                                                                               @Query("nam") String nam,
                                                                               @Query("page") int page,
                                                                               @Query("size") int size);

    @GET("api/XuLyGiayMoi/countAllGMPhoiHopTraLai")
    Observable<Response<Integer>> countAllGMPhoiHopTraLai(@Header("Authorization") String token,
                                                          @Query("nam") String nam);

    @POST("api/XuLyGiayMoi/duyetGMPhoiHopTraLai")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetGMPhoiHopTraLai(@Header("Authorization") String token,
                                                       @Field("id") int id,
                                                       @Field("idPhoPhong") int idPhoPhong,
                                                       @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                       @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                       @Field("chiDao") String chiDao,
                                                       @Field("chiDaoChuTri") String chiDaoChuTri,
                                                       @Field("phoGiamDocDonDoc") boolean phoGiamDocDonDoc,
                                                       @Field("hanGiaiQuyet") String hanGiaiQuyet,
                                                       @Field("idCanBoTuchoi") int idCanBoTuchoi,
                                                       @Field("nam") String nam);

    //phong stcphoi hop da chi dao

    @GET("api/XulyVanBan/getAllVBSTCPhoiHopDaChiDaoPhong")
    Observable<Response<ArrayList<PhongChuTriDaChiDao>>> getAllVBSTCPhoiHopDaChiDaoPhong(@Header("Authorization") String token,
                                                                                         @Query("nam") String nam,
                                                                                         @Query("page") int page,
                                                                                         @Query("size") int size);

    @GET("api/XulyVanBan/countAllVBSTCPhoiHopDaChiDaoPhong")
    Observable<Response<Integer>> countAllVBSTCPhoiHopDaChiDaoPhong(@Header("Authorization") String token,
                                                                    @Query("nam") String nam);

    @POST("api/XulyVanBan/duyetVBSTCPhoiHopDaChiDaoPhong")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBSTCPhoiHopDaChiDaoPhong(@Header("Authorization") String token,
                                                                 @Field("id") int id,
                                                                 @Field("idPhoPhong") int idPhoPhong,
                                                                 @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                                 @Field("idChuyenVien") int idChuyenVien,
                                                                 @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                 @Field("chiDao") String chiDao,
                                                                 @Field("chiDaoChuTri") String chiDaoChuTri,
                                                                 @Field("vanBanDauRaTruongPhong") String vanBanDauRaTruongPhong,
                                                                 @Field("vanBanQuanTrong") boolean vanBanQuanTrong,
                                                                 @Field("phoGiamDocDonDoc") boolean phoGiamDocDonDoc,
                                                                 @Field("hanGiaiQuyet") String hanGiaiQuyet,
                                                                 @Field("nam") String nam);

    //van ban phoi hop da chi dao
    @GET("api/XulyVanBan/getAllVBPhongPhoiHopDaChiDao")
    Observable<Response<ArrayList<VanBanPhoiHopDaChiDao>>> getAllVBPhongPhoiHopDaChiDao(@Header("Authorization") String token,
                                                                                        @Query("nam") String nam,
                                                                                        @Query("page") int page,
                                                                                        @Query("size") int size);

    @GET("api/XulyVanBan/countAllVBPhongPhoiHopDaChiDao")
    Observable<Response<Integer>> countAllVBPhongPhoiHopDaChiDao(@Header("Authorization") String token,
                                                                 @Query("nam") String nam);


    @POST("api/XulyVanBan/duyetVBPhongPhoiHopDaChiDao")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBPhongPhoiHopDaChiDao(@Header("Authorization") String token,
                                                              @Field("id") int id,
                                                              @Field("idPhoPhong") int idPhoPhong,
                                                              @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                              @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                              @Field("chiDao") String chiDao,
                                                              @Field("chiDaoChuTri") String chiDaoChuTri,
                                                              @Field("phoGiamDocDonDoc") boolean phoGiamDocDonDoc,
                                                              @Field("hanGiaiQuyet") String hanGiaiQuyet,
                                                              @Field("nam") String nam);

    //van banda hoan thanh cho lanh dao phong phe duyet trang thai 1:chua phe duyet,2:da phe duyet

    @GET("api/XulyVanBan/getAllVBDaHoanThanhChoLDPheDuyet")
    Observable<Response<ArrayList<VanBanHoanThanhChoLanhDaoPhongPheDuyet>>> getAllVBDaHoanThanhChoLDPheDuyet(@Header("Authorization") String token,
                                                                                                             @Query("nam") String nam,
                                                                                                             @Query("trangthai") int trangthai,
                                                                                                             @Query("page") int page,
                                                                                                             @Query("size") int size);

    @GET("api/XulyVanBan/getDetailVBQuaTrinhXuLy")
    Observable<Response<DetailVanBanChoLanhDaoPhongPheDuyet>> getDetailVBQuaTrinhXuLy(@Header("Authorization") String token,
                                                                                      @Query("id") int id,
                                                                                      @Query("nam") String nam);

    @GET("api/XuLyGiayMoi/getDetailGMQuyTrinhGiayMoi")
    Observable<Response<DeatailVanBanSoLuongVanBanPhongChuTri>> getDetailGMQuyTrinhGiayMoi(@Header("Authorization") String token,
                                                                                           @Query("id") int id,
                                                                                           @Query("nam") String nam);

    @GET("api/XuLyGiayMoi/getDetailGMChuyenVienXuLy")
    Observable<Response<DetailVanBanPhoiHopTraLai>> getDetailGMChuyenVienXuLy(@Header("Authorization") String token,
                                                                              @Query("id") int id,
                                                                              @Query("nam") String nam);

    @GET("api/XuLyGiayMoi/getDetailGMChuyenVienChuTriXuLy")
    Observable<Response<DetailGiayMoiPhongChuTriChoXuLy>> getDetailGMChuyenVienChuTriXuLy(@Header("Authorization") String token,
                                                                                          @Query("id") int id,
                                                                                          @Query("nam") String nam);

    @POST("api/XuLyGiayMoi/hoanThanhGMChuyenVienChuTriXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> hoanThanhGMChuyenVienChuTriXuLy(@Header("Authorization") String token,
                                                                  @Field("id") int id,
                                                                  @Field("ketQua") String ketQua,
                                                                  @Field("tenFileBaoCao") String tenFileBaoCao,
                                                                  @Field("nam") String nam);

    @POST("api/XuLyGiayMoi/hoanThanhGMChuyenVienXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> hoanThanhGMChuyenVienXuLy(@Header("Authorization") String token,
                                                            @Field("id") int id,
                                                            @Field("ketQua") String ketQua,
                                                            @Field("tenFileKetQua") String tenFileKetQua,
                                                            @Field("nam") String nam);

    @GET("api/XulyVanBan/getDetailVBChuyenVienXuLy")
    Observable<Response<DetailVanBanPhoiHopTraLai>> getDetailVBChuyenVienXuLy(@Header("Authorization") String token,
                                                                              @Query("nam") String nam,
                                                                              @Query("id") int id);


    @POST("api/XulyVanBan/hoanThanhVBChuyenVienXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> hoanThanhVBChuyenVienXuLy(@Header("Authorization") String token,
                                                            @Field("id") int id,
                                                            @Field("ketQua") String ketQua,
                                                            @Field("nam") String nam);

    @GET("api/XulyVanBan/countAllVBDaHoanThanhChoLDPheDuyet")
    Observable<Response<Integer>> countAllVBDaHoanThanhChoLDPheDuyet(@Header("Authorization") String token,
                                                                     @Query("nam") String nam,
                                                                     @Query("trangthai") int trangthai);

    @POST("api/XulyVanBan/duyetVBDaHoanThanhChoLDPheDuyet")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBDaHoanThanhChoLDPheDuyet(@Header("Authorization") String token,
                                                                  @Field("id") int id,
                                                                  @Field("vBCoDauRa") boolean vBCoDauRa,
                                                                  @Field("coSangtao") boolean coSangtao,
                                                                  @Field("nam") String nam);


    @POST("api/XulyVanBan/xoaKQPhongTL")
    @FormUrlEncoded
    Observable<Response<Boolean>> xoaKQPhongTL(@Header("Authorization") String token,
                                               @Field("nam") String nam,
                                               @Field("id") String id
    );

    @POST("api/XulyVanBan/tuChoiKetQuaHoanThanhChoLDPheDuyet")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiKetQuaHoanThanhChoLDPheDuyet(@Header("Authorization") String token,
                                                                     @Field("id") int id,
                                                                     @Field("noiDungTuChoi") String noiDungTuChoi,
                                                                     @Field("idNguoiHoanThanh") String idNguoiHoanThanh,
                                                                     @Field("nam") String nam);

    // giay moi da hoan thanh cho lanh dao phong phe duyet
    @GET("api/XuLyGiayMoi/getAllGMDaHoanThanhChoLDPheDuyet")
    Observable<Response<ArrayList<GMDaHoanThanhChoLanhDaoPhongPheDuyet>>> getAllGMDaHoanThanhChoLDPheDuyet(@Header("Authorization") String token,
                                                                                                           @Query("nam") String nam,
                                                                                                           @Query("page") int page,
                                                                                                           @Query("size") int size);

    @GET("api/XuLyGiayMoi/countAllGMDaHoanThanhChoLDPheDuyet")
    Observable<Response<Integer>> countAllGMDaHoanThanhChoLDPheDuyet(@Header("Authorization") String token,
                                                                     @Query("nam") String nam);

    @POST("api/XuLyGiayMoi/duyetGMDaHoanThanhChoLDPheDuyet")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetGMDaHoanThanhChoLDPheDuyet(@Header("Authorization") String token,
                                                                  @Field("id") int id,
                                                                  @Field("nam") String nam);

    @POST("api/XuLyGiayMoi/tuchoiGMDaHoanThanhChoLDPheDuyet")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuchoiGMDaHoanThanhChoLDPheDuyet(@Header("Authorization") String token,
                                                                   @Field("id") int id,
                                                                   @Field("nam") String nam);

    //bao cao cuoc hop cho duyet
    @GET("api/XuLyGiayMoi/getAllBaoCaoCuocHopChoDuyet")
    Observable<Response<ArrayList<BaoCaoCuocHopChoPheDuyet>>> getAllBaoCaoCuocHopChoDuyet(@Header("Authorization") String token,
                                                                                          @Query("nam") String nam,
                                                                                          @Query("page") int page,
                                                                                          @Query("size") int size);

    @GET("api/XuLyGiayMoi/countAllBaoCaoCuocHopChoDuyet")
    Observable<Response<Integer>> countAllBaoCaoCuocHopChoDuyet(@Header("Authorization") String token,
                                                                @Query("nam") String nam);

    @POST("api/XuLyGiayMoi/duyetBaoCaoCuocHopChoDuyet")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetBaoCaoCuocHopChoDuyet(@Header("Authorization") String token,
                                                             @Field("IdVB") int IdVB,
                                                             @Field("IdNoiDung") String IdNoiDung,
                                                             @Field("nam") String nam);

    @POST("api/XuLyGiayMoi/tuChoiBaoCaoCuocHopChoDuyet")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiBaoCaoCuocHopChoDuyet(@Header("Authorization") String token,
                                                              @Field("IdVB") int IdVB,
                                                              @Field("IdNoiDung") String IdNoiDung,
                                                              @Field("noiDung") String noiDung,
                                                              @Field("nam") String nam);


    //CONG TAC DANG CHO XU LY

    @GET("api/XulyVanBan/getAllVBCongTacDangChoXuLyPhong")
    Observable<Response<ArrayList<PhongChuTriChoXL>>> getAllVBCongTacDangChoXuLyPhong(@Header("Authorization") String token,
                                                                                      @Query("nam") String nam,
                                                                                      @Query("page") int page,
                                                                                      @Query("size") int size);

    @GET("api/XulyVanBan/countAllVBCongTacDangChoXuLyPhong")
    Observable<Response<Integer>> countAllVBCongTacDangChoXuLyPhong(@Header("Authorization") String token,
                                                                    @Query("nam") String nam);

    @POST("api/XulyVanBan/tuChoiVBCongTacDangChoXuLyPhong")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiVBCongTacDangChoXuLyPhong(@Header("Authorization") String token,
                                                                  @Field("id") int id,
                                                                  @Field("noiDungTuChoi") String noiDungTuChoi,
                                                                  @Field("ghiChu") String ghiChu,
                                                                  @Field("nam") String nam);

    @POST("api/XulyVanBan/duyetVBCongTacDangChoXuLyPhong")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBCongTacDangChoXuLyPhong(@Header("Authorization") String token,
                                                                 @Field("id") int id,
                                                                 @Field("idPhoPhong") int idPhoPhong,
                                                                 @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                                 @Field("idChuyenVien") int idChuyenVien,
                                                                 @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                 @Field("chiDao") String chiDao,
                                                                 @Field("chiDaoChuTri") String chiDaoChuTri,
                                                                 @Field("vanBanQuanTrong") boolean vanBanQuanTrong,
                                                                 @Field("phoGiamDocDonDoc") boolean phoGiamDocDonDoc,
                                                                 @Field("hanGiaiQuyet") String hanGiaiQuyet,
                                                                 @Field("nam") String nam);

    //dsvb xem de biet
    @GET("api/XulyVanBan/getallvbxemdebiet")
    Observable<Response<ArrayList<XemDeBiet>>> getallvbxemdebiet(@Header("Authorization") String token,
                                                                 @Query("nam") String nam,
                                                                 @Query("id_tk") String id_tk,
                                                                 @Query("page") int page,
                                                                 @Query("size") int size);

    @GET("api/XulyVanBan/countallvbxemdebiet")
    Observable<Response<Integer>> countallvbxemdebiet(@Header("Authorization") String token,
                                                      @Query("nam") String nam,
                                                      @Query("id_tk") String id_tk);

    //dsvb pgd biet de don doc

    @GET("api/XulyVanBan/getallvbtheodoidondoc")
    Observable<Response<ArrayList<TheoDoiDonDoc>>> getallvbtheodoidondoc(@Header("Authorization") String token,
                                                                         @Query("nam") String nam,
                                                                         @Query("id_tk") String id_tk,
                                                                         @Query("page") int page,
                                                                         @Query("size") int size);

    @GET("api/XulyVanBan/countallvbtheodoidondoc")
    Observable<Response<Integer>> countallvbtheodoidondoc(@Header("Authorization") String token,
                                                          @Query("nam") String nam,
                                                          @Query("id_tk") String id_tk);

    //PHONG PHOI HOP CHO XU LY
    @GET("api/XulyVanBan/getAllVBPhongPhoiHopChoXuLy")
    Observable<Response<ArrayList<VanBanGiaoPhongPhoiHop>>> getAllVBPhongPhoiHopChoXuLy(@Header("Authorization") String token,
                                                                                        @Query("nam") String nam,
                                                                                        @Query("page") int page,
                                                                                        @Query("size") int size);

    @GET("api/XulyVanBan/countAllVBPhongPhoiHopChoXuLy")
    Observable<Response<Integer>> coutAllVBPhongPhoiHopChoXuLy(@Header("Authorization") String token,
                                                               @Query("nam") String nam);

    @GET("api/XulyVanBan/getDetailVBChuyenVienXuLy")
    Observable<Response<DetailVbphongPhoiHopChoXuLy>> getVBPhongPhoiHopChoXuLyById(@Header("Authorization") String token,
                                                                                   @Query("nam") String nam,
                                                                                   @Query("id") int id);

    @POST("api/XulyVanBan/hoanThanhVBChuyenVienXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> hoanThanhVBPhongPhoiHopChoXuLy(@Header("Authorization") String token,
                                                                 @Field("id") int id,
                                                                 @Field("ketQua") String ketQua,
                                                                 @Field("nam") String nam);

    // DANH SACH VB THEO PHONG
    @GET("api/XulyVanBan/Thongke")
    Observable<Response<ArrayList<DSVB_TheoPhong>>> Thongke(@Header("Authorization") String token,
                                                            @Query("nam") String nam,
                                                            @Query("id_tk") String id_tk,
                                                            @Query("ngaybatdau") String ngaybatdau,
                                                            @Query("ngayketthuc") String ngayketthuc);

    @GET("api/VanBanDen/getThongKeTheoPhong")
    Observable<Response<ArrayList<ThongKeTheoPhong>>> getThongKeTheoPhong(@Header("Authorization") String token,
                                                                          @Query("idUser") String idUser,
                                                                          @Query("nam") String nam,
                                                                          @Query("idlanhdao") String idlanhdao,
                                                                          @Query("ngaynhaptu") String ngaynhaptu,
                                                                          @Query("ngaynhapden") String ngaynhapden);

    @GET("api/VanBanDen/getThongKeTheoPhongDetail")
    Observable<Response<ArrayList<ThongKeTheoPhong>>> getThongKeTheoPhongDetail(@Header("Authorization") String token,
                                                                                @Query("idUser") String idUser,
                                                                                @Query("nam") String nam,
                                                                                @Query("idpb") int idpb,
                                                                                @Query("idlanhdao") String idlanhdao,
                                                                                @Query("ngaynhaptu") String ngaynhaptu,
                                                                                @Query("ngaynhapden") String ngaynhapden);

    @GET("api/VanBanDen/getVB_thongKetheoPhong")
    Observable<Response<ArrayList<DetailVanBanDenTongThe>>> getVB_thongKetheoPhong(@Header("Authorization") String token,
                                                                                   @Query("idUser") String idUser,
                                                                                   @Query("nam") String nam,
                                                                                   @Query("ma") int ma,
                                                                                   @Query("sangtao") int sangtao,
                                                                                   @Query("idlanhdao") String idlanhdao,
                                                                                   @Query("chuagiaquyet") int chuagiaquyet,
                                                                                   @Query("dagiaiquyet") int dagiaiquyet,
                                                                                   @Query("ngaynhaptu") String ngaynhaptu,
                                                                                   @Query("ngaynhapden") String ngaynhapden);

    //thong ke van ban theo pho giam doc

    @GET("api/VanBanDen/getThongKeTheoPhoGiamDoc")
    Observable<Response<ArrayList<ThongKeTheoPhong>>> getThongKeTheoPhoGiamDoc(@Header("Authorization") String token,
                                                                               @Query("idUser") String idUser,
                                                                               @Query("nam") String nam,
                                                                               @Query("ngaynhaptu") String ngaynhaptu,
                                                                               @Query("ngaynhapden") String ngaynhapden);

    @POST("api/XulyVanBan/duyetvbdenchoxuly")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetvbdenchoxuly(@Header("Authorization") String token,
                                                    @Field("id_tk") String id_tk,
                                                    @Field("id_vb") int id_vb,
                                                    @Field("id_phogiamdoc") int id_phogiamdoc,
                                                    @Field("id_phongchutri") int id_phongchutri,
                                                    @Field("id_phong_phoihops") String id_phong_phoihops,
                                                    @Field("chidao_phogiamdoc") String chidao_phogiamdoc,
                                                    @Field("chidao_phongchutri") String chidao_phongchutri,
                                                    @Field("phogiamdocthammuu") boolean phogiamdocthammuu,
                                                    @Field("han_giai_quyet") String han_giai_quyet,
                                                    @Field("is_vbquantrong") boolean is_vbquantrong,
                                                    @Field("nam") String nam);

    @POST("api/XulyVanBan/duyetvbcongtacdangchoxuly")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetvbcongtacdangchoxuly(@Header("Authorization") String token,
                                                            @Field("id_tk") String id_tk,
                                                            @Field("id_vb") int id_vb,
                                                            @Field("id_phogiamdoc") int id_phogiamdoc,
                                                            @Field("id_phongchutri") int id_phongchutri,
                                                            @Field("id_phong_phoihops") String id_phong_phoihops,
                                                            @Field("chidao_phogiamdoc") String chidao_phogiamdoc,
                                                            @Field("chidao_phongchutri") String chidao_phongchutri,
                                                            @Field("phogiamdocthammuu") boolean phogiamdocthammuu,
                                                            @Field("han_giai_quyet") String han_giai_quyet,
                                                            @Field("is_vbquantrong") boolean is_vbquantrong);


    //get danh muc

    @GET("api/DanhMuc/getAllChuyenVienDonViCapHai")
    Observable<Response<ArrayList<GiamdocVaPhoGiamdoc>>> getAllChuyenVienDonViCapHai(@Header("Authorization") String token,
                                                                                     @Query("nam") String nam);

    @GET("api/DanhMuc/getAllPhoPhongDonViCapHai")
    Observable<Response<ArrayList<GiamdocVaPhoGiamdoc>>> getAllPhoPhongDonViCapHai(@Header("Authorization") String token,
                                                                                   @Query("nam") String nam);

    @GET("api/DanhMuc/getAllPhoPhongBanCC")
    Observable<Response<ArrayList<GiamdocVaPhoGiamdoc>>> getAllPhoPhongBanCC(@Header("Authorization") String token,
                                                                             @Query("nam") String nam);

    @GET("api/DanhMuc/getAlCVPhongBanCC")
    Observable<Response<ArrayList<GiamdocVaPhoGiamdoc>>> getAlCVPhongBanCC(@Header("Authorization") String token,
                                                                           @Query("nam") String nam);

    @GET("api/DanhMuc/getAllPhongBanDonViCapHai")
    Observable<Response<ArrayList<PhongBan>>> getAllPhongBanDonViCapHai(@Header("Authorization") String token,
                                                                        @Query("nam") String nam);

    @GET("api/DanhMuc/getAllTruongPhongDonViCapHai")
    Observable<Response<ArrayList<GiamdocVaPhoGiamdoc>>> getAllTruongPhongDonViCapHai(@Header("Authorization") String token,
                                                                                      @Query("nam") String nam);

    @GET("api/DanhMuc/getAllGiamDoc")
    Observable<Response<ArrayList<GiamdocVaPhoGiamdoc>>> getAllGiamDoc(@Header("Authorization") String token,
                                                                       @Query("nam") String nam);

    @GET("api/DanhMuc/getAllTruongPhongBan")
    Observable<Response<ArrayList<GiamdocVaPhoGiamdoc>>> getAllTruongPhongBan(@Header("Authorization") String token,
                                                                              @Query("nam") String nam);

    @GET("api/DanhMuc/getAllChiCucPho")
    Observable<Response<ArrayList<GiamdocVaPhoGiamdoc>>> getAllChiCucPho(@Header("Authorization") String token,
                                                                         @Query("nam") String nam);

    @GET("api/DanhMuc/getAllTruongPhongChiCuc")
    Observable<Response<ArrayList<GiamdocVaPhoGiamdoc>>> getAllTruongPhongChiCuc(@Header("Authorization") String token,
                                                                                 @Query("nam") String nam);


    @GET("api/DanhMuc/getAllDoKhan")
    Observable<Response<ArrayList<DoMat>>> getAllDoKhan(@Header("Authorization") String token);

    @GET("api/DanhMuc/getAllDoMat")
    Observable<Response<ArrayList<DoMat>>> getAllDoMat(@Header("Authorization") String token);

    @GET("api/DanhMuc/getAllKhuVuc")
    Observable<Response<ArrayList<KhuVuc>>> getAllKhuVuc(@Header("Authorization") String token,
                                                         @Query("nam") String nam);

    @GET("api/DanhMuc/getAllLoaiVanBan")
    Observable<Response<ArrayList<KhuVuc>>> getAllLoaiVanBan(@Header("Authorization") String token,
                                                             @Query("nam") String nam);

    @GET("api/DanhMuc/getAllLoaiVanBan1")
    Observable<Response<ArrayList<LoaiVanBan_Nhap>>> getAllLoaiVanBan_nhap(@Header("Authorization") String token,
                                                                           @Query("nam") String nam);

    @GET("api/DanhMuc/getAllChucVu")
    Observable<Response<ArrayList<KhuVuc>>> getAllChucVu(@Header("Authorization") String token,
                                                         @Query("nam") String nam);

    @GET("api/DanhMuc/getAllNguoiKy_nhap")
    Observable<Response<ArrayList<NguoiKy_nhap>>> getAllNguoiKy_nhap(@Header("Authorization") String token,
                                                                     @Query("nam") String nam);

    @GET("api/DanhMuc/getAllNguoiKy")
    Observable<Response<ArrayList<GiamdocVaPhoGiamdoc>>> getAllNguoiKy(@Header("Authorization") String token,
                                                                       @Query("nam") String nam);

    @GET("api/DanhMuc/getAllNguoiKyVB")
    Observable<Response<ArrayList<KhuVuc>>> getAllNguoiKyVB(@Header("Authorization") String token,
                                                            @Query("nam") String nam);

    @GET("api/DanhMuc/getAllLinhVuc")
    Observable<Response<ArrayList<KhuVuc>>> getAllLinhVuc(@Header("Authorization") String token,
                                                          @Query("nam") String nam);

    @GET("api/DanhMuc/getAllDonVi")
    Observable<Response<ArrayList<KhuVuc>>> getAllDonVi(@Header("Authorization") String token,
                                                        @Query("nam") String nam);

    @GET("api/DanhMuc/getlistCB_lanhdao")
    Observable<Response<ArrayList<GiamdocVaPhoGiamdoc>>> getlistCB_lanhdao(@Header("Authorization") String token,
                                                                           @Query("nam") String nam);

    @GET("api/DanhMuc/getAllCanBoPhong")
    Observable<Response<ArrayList<GiamdocVaPhoGiamdoc>>> getAllCanBoPhong(@Header("Authorization") String token,
                                                                          @Query("nam") String nam);

    @GET("api/DanhMuc/getCBxem_choxl")
    Observable<Response<ArrayList<GiamdocVaPhoGiamdoc>>> getCBxem_choxl(@Header("Authorization") String token,
                                                                        @Query("id_tk") String id_tk,
                                                                        @Query("nam") String nam);

    @GET("api/DanhMuc/getlanhdaophong")
    Observable<Response<ArrayList<GiamdocVaPhoGiamdoc>>> getlanhdaophong(@Header("Authorization") String token,
                                                                         @Query("id_tk") String id_tk,
                                                                         @Query("nam") String nam);

    @GET("api/DanhMuc/getallnoiduthao")
    Observable<Response<ArrayList<SelectNoiDuThao>>> getallnoiduthao(@Header("Authorization") String token,
                                                                     @Query("id_tk") String id_tk,
                                                                     @Query("nam") String nam);

    @GET("api/VanBanDi/getSokyhieu")
    Observable<Response<String>> getSokyhieu(@Header("Authorization") String token,
                                             @Query("id_lvb") int id_lvb,
                                             @Query("sovb") int sovb,
                                             @Query("id_noiduthao") int id_noiduthao,
                                             @Query("nam") String nam);

    @GET("api/VanBanDi/getchucvu")
    Observable<Response<String>> getchucvu(@Header("Authorization") String token,
                                           @Query("id_lanhdao") int id_lanhdao,
                                           @Query("nam") String nam);

    @POST("api/VanBanDi/them_capnhapVB")
    @FormUrlEncoded
    Observable<Response<Boolean>> them_capnhapVB(@Header("Authorization") String token,
                                                 @Field("id_tk") String id_tk,
                                                 @Field("id_vb") int id_vb,
                                                 @Field("nam") String nam,
                                                 @Field("soVB") int soVB,
                                                 @Field("ngay_thang") String ngay_thang,
                                                 @Field("linhvuc") String linhvuc,
                                                 @Field("sotrang") int sotrang,
                                                 @Field("soden") String soden,
                                                 @Field("trichyeu") String trichyeu,
                                                 @Field("ykien") String ykien,
                                                 @Field("id_loaivanban") String id_loaivanban,
                                                 @Field("id_lanhdaophong") String id_lanhdaophong,
                                                 @Field("id_phongduthao") String id_phongduthao,
                                                 @Field("email") ArrayList<String> email,
                                                 @Field("email_ngoai") String email_ngoai,
                                                 @Field("ngaymoi") String ngaymoi,
                                                 @Field("giomoi") String giomoi,
                                                 @Field("diadiemmoi") String diadiemmoi,
                                                 @Field("id_nguoiky") int id_nguoiky,
                                                 @Field("skyhieu") String skyhieu,
                                                 @Field("chucvu") String chucvu,
                                                 @Field("duthao") int duthao);


    @GET("api/DanhMuc/getAllTK_noiden")
    Observable<Response<ArrayList<VanBanTheoLoaiNoiDen>>> getAllTK_noiden(@Header("Authorization") String token);

    @GET("api/DanhMuc/getAllPhoGiamDoc")
    Observable<Response<ArrayList<GiamdocVaPhoGiamdoc>>> getAllPhoGiamDoc(@Header("Authorization") String token,
                                                                          @Query("nam") String nam);

    @GET("api/DanhMuc/getAllPhongBan")
    Observable<Response<ArrayList<PhongBan>>> getAllPhongBan(@Header("Authorization") String token,
                                                             @Query("nam") String nam);

    @GET("api/DanhMuc/getAllPhoPhongBan")
    Observable<Response<ArrayList<GiamdocVaPhoGiamdoc>>> getAllPhoPhongBan(@Header("Authorization") String token,
                                                                           @Query("nam") String nam);

    @GET("api/DanhMuc/getAllChuyenVien")
    Observable<Response<ArrayList<GiamdocVaPhoGiamdoc>>> getAllChuyenVien(@Header("Authorization") String token,
                                                                          @Query("nam") String nam);

    @GET("api/DanhMuc/getAllTuan")
    Observable<Response<ArrayList<String>>> getAllTuan(@Header("Authorization") String token,
                                                       @Query("nam") String nam);

    @GET("api/DanhMuc/getAllThongBao")
    Observable<Response<ArrayList<ThongBao>>> getAllThongBao(@Header("Authorization") String token,
                                                             @Query("page") int page,
                                                             @Query("size") int size,
                                                             @Query("nam") String nam);

    //0: tất cả : 1 chưa xem : 2 đã xem

    @GET("api/DanhMuc/countThongBao")
    Observable<Response<Integer>> countThongBao(@Header("Authorization") String token,
                                                @Query("trangThai") int trangThai,
                                                @Query("nam") String nam);

    @GET("api/Account/dangXuat")
    Observable<Response<Boolean>> dangXuat(@Query("fireBaseToken") String firebaseToken);

    @POST("api/DanhMuc/UpdateThongBao")
    @FormUrlEncoded
    Observable<Response<Boolean>> UpdateThongBao(@Header("Authorization") String token,
                                                 @Field("id") int id,
                                                 @Field("nam") String nam);

    @GET("api/XuLyGiayMoi/getGMCapNhat")
    Observable<Response<GiayMoiCapNhat>> getGMCapNhat(@Header("Authorization") String token,
                                                      @Query("id") int id,
                                                      @Query("nam") String nam);

    @POST("api/XuLyGiayMoi/duyetGMCapNhat")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetGMCapNhat(@Header("Authorization") String token,
                                                 @Field("id") int id,
                                                 @Field("idkhuVuc") int idkhuVuc,
                                                 @Field("soKyHieu") String soKyHieu,
                                                 @Field("noiGuiDen") String noiGuiDen,
                                                 @Field("loaiVanBan") String loaiVanBan,
                                                 @Field("ngayKy") String ngayKy,
                                                 @Field("trichYeu") String trichYeu,
                                                 @Field("nguoiKy") String nguoiKy,
                                                 @Field("gioHop") String gioHop,
                                                 @Field("ngayHop") String ngayHop,
                                                 @Field("noiDung") String noiDung,
                                                 @Field("diaDiem") String diaDiem,
                                                 @Field("nguoiChuTri") String nguoiChuTri,
                                                 @Field("chucVu") String chucVu,
                                                 @Field("hanGiaiQuyet") String hanGiaiQuyet,
                                                 @Field("soTrang") String soTrang,
                                                 @Field("soDen") String soDen,
                                                 @Field("ngayNhan") String ngayNhan,
                                                 @Field("idDoMat") int idDoMat,
                                                 @Field("idDoKhan") int idDoKhan,
                                                 @Field("vBQPPL") int vBQPPL,
                                                 @Field("STC_CT") int STC_CT,
                                                 @Field("TBKL") int TBKL,
                                                 @Field("nam") String nam);

    //get van ban qua han do lanh dao chi dao
    @GET("api/XulyVanBan/getallvbquahandolanhdaochidao")
    Observable<Response<ArrayList<DSVB_QuaHan>>> getallvbquahandolanhdaochidao(@Header("Authorization") String token,
                                                                               @Query("nam") String nam,
                                                                               @Query("id_tk") String id_tk,
                                                                               @Query("page") int page,
                                                                               @Query("size") int size);

    @GET("api/XulyVanBan/countvbquahandolanhdaochidao")
    Observable<Response<Integer>> countvbquahandolanhdaochidao(@Header("Authorization") String token,
                                                               @Query("nam") String nam,
                                                               @Query("id_tk") String id_tk);


    @GET("api/XulyVanBan/getbyidvbquahandolanhdaochidao")
    Observable<Response<DSVB_QuaHan>> getbyidvbquahandolanhdaochidao(@Header("Authorization") String token,
                                                                     @Query("id_vb") int id_vb,
                                                                     @Query("id_tk") String id_tk,
                                                                     @Query("nam") String nam);

    @POST("api/XulyVanBan/themHanGiaiQuyetVBQuaHan")
    @FormUrlEncoded
    Observable<Response<Boolean>> themHanGiaiQuyetVBQuaHan(@Header("Authorization") String token,
                                                           @Field("id") int id,
                                                           @Field("hanDeXuat") String hanDeXuat,
                                                           @Field("lydo") String ly_do,
                                                           @Field("nam") String nam);

    @POST("api/XulyVanBan/tuChoiHanGiaiQuyetVBQuaHan")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiHanGiaiQuyetVBQuaHan(@Header("Authorization") String token,
                                                             @Field("id") int id,
                                                             @Field("noiDungTuChoi") String noiDungTuChoi,
                                                             @Field("ghiChu") String ghiChu,
                                                             @Field("nam") String nam);

    @GET("api/XulyVanBan/getDetailbyidvbquahandolanhdaochidao")
    Observable<Response<DetailVanBanQuahan>> getDetailbyidvbquahandolanhdaochidao(@Header("Authorization") String token,
                                                                                  @Query("id_vb") int id_vb,
                                                                                  @Query("nam") String nam);

    @POST("api/XulyVanBan/tuChoiTPVBQuaHan")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiTPVBQuaHan(@Header("Authorization") String token,
                                                   @Field("id") int id,
                                                   @Field("noiDungTuChoi") String noiDungTuChoi,
                                                   @Field("ghiChu") String ghiChu,
                                                   @Field("nam") String nam);


    //get van ban cong tac dang cho xu ly
    @GET("api/XulyVanBan/getallvbcongtacdangchoxuly")
    Observable<Response<ArrayList<DSVB_DaChiDao>>> getallvbcongtacdangchoxuly(@Header("Authorization") String token,
                                                                              @Query("nam") String nam,
                                                                              @Query("id_tk") String id_tk,
                                                                              @Query("page") int page,
                                                                              @Query("size") int size);

    @GET("api/XulyVanBan/getbyidvbcongtacdangchoxuly")
    Observable<Response<DSVB_DaChiDao>> getbyidvbcongtacdangchoxuly(@Header("Authorization") String token,
                                                                    @Query("id_vb") int id_vb,
                                                                    @Query("id_tk") String id_tk,
                                                                    @Query("nam") String nam);

    @GET("api/XulyVanBan/Countvbcongtacdangchoxuly")
    Observable<Response<Integer>> Countvbcongtacdangchoxuly(@Header("Authorization") String token,
                                                            @Query("nam") String nam,
                                                            @Query("id_tk") String id_tk);

    // luu ket qua
    @POST("api/XulyVanBan/luuketquavbdenchoxuly")
    @FormUrlEncoded
    Observable<Response<Boolean>> luuketqua(@Header("Authorization") String token,
                                            @Field("id_vb") int id_vb,
                                            @Field("id_tk") String id_tk,
                                            @Field("ketqua") String ketqua,
                                            @Field("luu_vao_kho") int luu_vao_kho,
                                            @Field("chammuon") String chammuon,
                                            @Field("hoanthanh") int hoanthanh,
                                            @Field("nam") String nam);

    @POST("api/XulyVanBan/chonDeLuuVanBan")
    @FormUrlEncoded
    Observable<Response<Boolean>> chonDeLuuVanBan(@Header("Authorization") String token,
                                                  @Field("id_vb") int id_vb,
                                                  @Field("nam") String nam);

    // get don thu kntc
    @GET("api/XulyVanBan/getalldonthukntc")
    Observable<Response<ArrayList<DonThuKNTC>>> getalldonthukntc(@Header("Authorization") String token,
                                                                 @Query("nam") String nam,
                                                                 @Query("id_tk") String id_tk,
                                                                 @Query("status") int status,
                                                                 @Query("page") int page,
                                                                 @Query("size") int size);

    @GET("api/XulyVanBan/countdonthukntc")
    Observable<Response<Integer>> countdonthukntc(@Header("Authorization") String token,
                                                  @Query("nam") String nam,
                                                  @Query("id_tk") String id_tk,
                                                  @Query("status") int status);

    @GET("api/XulyVanBan/getbyiddonthukntc")
    Observable<Response<NDVB_DonThu>> getbyiddonthukntc(@Header("Authorization") String token,
                                                        @Query("id_vb") int id_vb,
                                                        @Query("id_tk") String id_tk,
                                                        @Query("nam") String nam);

    // dsvb quan trong cua so
    @GET("api/XulyVanBan/getallvbquantrong")
    Observable<Response<ArrayList<DSVB_QuanTrong>>> getallvbquantrong(@Header("Authorization") String token,
                                                                      @Query("nam") String nam,
                                                                      @Query("id_tk") String id_tk,
                                                                      @Query("status") int status,
                                                                      @Query("page") int page,
                                                                      @Query("size") int size);

    @GET("api/XulyVanBan/countvbquantrong")
    Observable<Response<Integer>> countvbquantrong(@Header("Authorization") String token,
                                                   @Query("nam") String nam,
                                                   @Query("id_tk") String id_tk,
                                                   @Query("status") int status);

    @GET("api/XulyVanBan/getbyidvbquantrong")
    Observable<Response<NDVB_QuanTrong>> getbyidvbquantrong(@Header("Authorization") String token,
                                                            @Query("id_vb") int id_vb,
                                                            @Query("id_tk") String id_tk,
                                                            @Query("nam") String nam);

    @GET("api/XulyVanBan/boquantrong")
    Observable<Response<Boolean>> boquantrong(@Header("Authorization") String token,
                                              @Query("id_vb") int id_vb,
                                              @Query("id_tk") String id_tk,
                                              @Query("nam") String nam);

    // thong ke van ban theo lanh dao chi dao
    @GET("api/VanBanDen/getsoluongvb_Theo_PGD")
    Observable<Response<ArrayList<ThongKeLanhDaoChiDao>>> getsoluongvb_Theo_PGD(@Header("Authorization") String token,
                                                                                @Query("idUser") String idUser,
                                                                                @Query("nam") String nam);

    @GET("api/VanBanDen/getsoluongvb_Theo_Phongban")
    Observable<Response<ArrayList<ThongKeLanhDaoChiDaoTheoPhong>>> getsoluongvb_Theo_Phongban(@Header("Authorization") String token,
                                                                                              @Query("idUser") String idUser,
                                                                                              @Query("nam") String nam);

    // neesuthieeus io nao thì truyen 0
    @GET("api/VanBanDen/thongke_vbLDdetail")
    Observable<Response<ThongKeVanBan>> thongke_vbLDdetail(@Header("Authorization") String token,
                                                           @Query("idGd") String idGd,
                                                           @Query("nam") String nam,
                                                           @Query("idPgd") int idPgd,
                                                           @Query("idphongban") int idphongban);

    @GET("api/VanBanDen/getVB_TKVB_theoLD")
    Observable<Response<ArrayList<DetailVanBanTheoLanhDao>>> getVB_TKVB_theoLD(@Header("Authorization") String token,
                                                                               @Query("idGd") String idGd,
                                                                               @Query("nam") String nam,
                                                                               @Query("dunghan") int dunghan,
                                                                               @Query("dalam") int dalam,
                                                                               @Query("idPgd") int idPgd,
                                                                               @Query("idphongban") int idphongban,
                                                                               @Query("page") int page,
                                                                               @Query("size") int size);

    @GET("api/KeHoachCongTacDanhGia/gettkdanhgiakehoach")
    Observable<Response<ArrayList<DetailDanhGiaKeHoach>>> gettkdanhgiakehoach(@Header("Authorization") String token,
                                                                              @Query("id_tk") String id_tk,
                                                                              @Query("thang") int thang,
                                                                              @Query("nam") String nam);


    // To cong tac
    //2 : hoàn thành , 1 : Chưa hoàn thành
    @GET("api/XulyVanBan/getalltocongtac")
    Observable<Response<ArrayList<ToCongTac>>> getalltocongtac(@Header("Authorization") String token,
                                                               @Query("nam") String nam,
                                                               @Query("id_tk") String id_tk,
                                                               @Query("status") int status,
                                                               @Query("page") int page,
                                                               @Query("size") int size);

    @GET("api/XulyVanBan/counttocongtac")
    Observable<Response<Integer>> counttocongtac(@Header("Authorization") String token,
                                                 @Query("nam") String nam,
                                                 @Query("id_tk") String id_tk,
                                                 @Query("status") int status);

    @GET("api/XulyVanBan/getbyidtocongtac")
    Observable<Response<NDVB_ToCongTac>> getbyidtocongtac(@Header("Authorization") String token,
                                                          @Query("id_vb") int id_vb,
                                                          @Query("id_tk") String id_tk,
                                                          @Query("nam") String nam);

    // giay moi cho lanh dao xu ly
    @GET("api/XuLyGiayMoi/countgiaymoicholanhdaoxuly")
    Observable<Response<Integer>> countgiaymoicholanhdaoxuly(@Header("Authorization") String token,
                                                             @Query("nam") String nam,
                                                             @Query("id_tk") String id_tk,
                                                             @Query("loaivanban") String loaivanban,
                                                             @Query("sokyhieu") String sokyhieu,
                                                             @Query("donvi") String donvi,
                                                             @Query("ngayky") String ngayky,
                                                             @Query("ngaynhap") String ngaynhap,
                                                             @Query("ngayden") String ngayden,
                                                             @Query("trichyeu") String trichyeu,
                                                             @Query("nguoiky") String nguoiky,
                                                             @Query("soden") String soden,
                                                             @Query("chucvu") String chucvu,
                                                             @Query("nguoinhap") String nguoinhap);

    @GET("api/XuLyGiayMoi/getallgiaymoicholanhdaoxuly")
    Observable<Response<ArrayList<GiayMoiChoLanhDaoXuLy>>> getallgiaymoicholanhdaoxuly(@Header("Authorization") String token,
                                                                                       @Query("nam") String nam,
                                                                                       @Query("id_tk") String id_tk,
                                                                                       @Query("page") int page,
                                                                                       @Query("size") int size,
                                                                                       @Query("loaivanban") String loaivanban,
                                                                                       @Query("sokyhieu") String sokyhieu,
                                                                                       @Query("donvi") String donvi,
                                                                                       @Query("ngayky") String ngayky,
                                                                                       @Query("ngaynhap") String ngaynhap,
                                                                                       @Query("ngayden") String ngayden,
                                                                                       @Query("trichyeu") String trichyeu,
                                                                                       @Query("nguoiky") String nguoiky,
                                                                                       @Query("soden") String soden,
                                                                                       @Query("chucvu") String chucvu,
                                                                                       @Query("nguoinhap") String nguoinhap);

    @GET("api/XuLyGiayMoi/getgiaymoicholanhdaoxulybyid")
    Observable<Response<DetailGiayMoi>> getgiaymoicholanhdaoxulybyid(@Header("Authorization") String token,
                                                                     @Query("id_giaymoi") int id_giaymoi,
                                                                     @Query("id_tk") String id_tk,
                                                                     @Query("nam") String nam);

    @POST("api/XuLyGiayMoi/duyetgiaymoicholanhdaoxuly")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetgiaymoicholanhdaoxuly(@Header("Authorization") String token,
                                                             @Field("id_tk") String id_tk,
                                                             @Field("id_giaymoi") int id_giaymoi,
                                                             @Field("id_phogiamdoc") int id_phogiamdoc,
                                                             @Field("id_phongchutri") int id_phongchutri,
                                                             @Field("id_phong_phoihops") String id_phong_phoihops,
                                                             @Field("chidao_phogiamdoc") String chidao_phogiamdoc,
                                                             @Field("chidao_phongchutri") String chidao_phongchutri,
                                                             @Field("giamdoc_duhop") boolean giamdoc_duhop,
                                                             @Field("phong_duhop") boolean phong_duhop,
                                                             @Field("han_giai_quyet") String han_giai_quyet,
                                                             @Field("is_vbquantrong") boolean is_vbquantrong,
                                                             @Field("nam") String nam);

    @POST("api/XuLyGiayMoi/duyetgiaymoilanhdaodaxuly")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetgiaymoilanhdaodaxuly(@Header("Authorization") String token,
                                                            @Field("id_tk") String id_tk,
                                                            @Field("id_giaymoi") int id_giaymoi,
                                                            @Field("id_giamdoc") int id_giamdoc,
                                                            @Field("id_phogiamdoc") int id_phogiamdoc,
                                                            @Field("id_phongchutri") int id_phongchutri,
                                                            @Field("id_phong_phoihops") String id_phong_phoihops,
                                                            @Field("chidao_phogiamdoc") String chidao_phogiamdoc,
                                                            @Field("chidao_giamdoc") String chidao_giamdoc,
                                                            @Field("chidao_phongchutri") String chidao_phongchutri,
                                                            @Field("giamdoc_duhop") boolean giamdoc_duhop,
                                                            @Field("phong_duhop") boolean phong_duhop,
                                                            @Field("han_giai_quyet") String han_giai_quyet,
                                                            @Field("is_vbquantrong") boolean is_vbquantrong,
                                                            @Field("nam") String nam);

    @POST("api/XuLyGiayMoi/createsoanbaocao")
    @FormUrlEncoded
    Observable<Response<Boolean>> createsoanbaocao(@Header("Authorization") String token,
                                                   @Field("id_vb") int id_vb,
                                                   @Field("id_tk") String id_tk,
                                                   @Field("ketluan") String ketluan,
                                                   @Field("dexuat") String dexuat,
                                                   @Field("chidao_phongchutri") String chidao_phongchutri,
                                                   @Field("nguoinhans") String nguoinhans,
                                                   @Field("phongbans") String phongbans);


    @Multipart
    @POST("api/XuLyGiayMoi/xacnhanhoanthanhcv")
    @FormUrlEncoded
    Observable<Response<Boolean>> xacnhanhoanthanhcv(@Header("Authorization") String token,
                                                     @Field("id_vb") int id_vb,
                                                     @Field("id_tk") String id_tk,
                                                     @Field("ketqua") String ketqua,
                                                     @Part ArrayList<MultipartBody.Part> fileName,
                                                     @Field("nam") String nam);

    //giay moi xem de biet
    @GET("api/XuLyGiayMoi/getallgiaymoixemdebiet")
    Observable<Response<ArrayList<GiayMoiXemDeBiet>>> getallgiaymoixemdebiet(@Header("Authorization") String token,
                                                                             @Query("nam") String nam,
                                                                             @Query("id_tk") String id_tk,
                                                                             @Query("page") int page,
                                                                             @Query("size") int size);

    @GET("api/XuLyGiayMoi/countallgiayxemdebiet")
    Observable<Response<Integer>> countallgiayxemdebiet(@Header("Authorization") String token,
                                                        @Query("nam") String nam,
                                                        @Query("id_tk") String id_tk);

    //giay moi lanh dao da chi dao
    @GET("api/XuLyGiayMoi/countgiaymoilanhdaodaxuly")
    Observable<Response<Integer>> countgiaymoilanhdaodaxuly(@Header("Authorization") String token,
                                                            @Query("nam") String nam,
                                                            @Query("id_tk") String id_tk);

    @GET("api/XuLyGiayMoi/getgiaymoilanhdaodaxulybyid")
    Observable<Response<DetailGiayMoi>> getgiaymoilanhdaodaxulybyid(@Header("Authorization") String token,
                                                                    @Query("id_giaymoi") int id_giaymoi,
                                                                    @Query("id_tk") String id_tk,
                                                                    @Query("nam") String nam);

    @GET("api/XuLyGiayMoi/getallgiaymoilanhdaodaxuly")
    Observable<Response<ArrayList<GiayMoiChoLanhDaoXuLy>>> getallgiaymoilanhdaodaxuly(@Header("Authorization") String token,
                                                                                      @Query("nam") String nam,
                                                                                      @Query("id_tk") String id_tk,
                                                                                      @Query("page") int page,
                                                                                      @Query("size") int size);

    // giay moi cua so
    @GET("api/XuLyGiayMoi/getallgiaymoi")
    Observable<Response<ArrayList<DSGiayMoiDenCuaSo>>> getallgiaymoi(@Header("Authorization") String token,
                                                                     @Query("nam") String nam,
                                                                     @Query("id_tk") String id_tk,
                                                                     @Query("type") int type,
                                                                     @Query("page") int page,
                                                                     @Query("size") int size);

    @GET("api/XuLyGiayMoi/countgiaymoi")
    Observable<Response<Integer>> countgiaymoi(@Header("Authorization") String token,
                                               @Query("nam") String nam,
                                               @Query("id_tk") String id_tk,
                                               @Query("type") int type);

    @GET("api/XuLyGiayMoi/getgiaymoibyid")
    Observable<Response<DetailGiayMoi>> getgiaymoibyid(@Header("Authorization") String token,
                                                       @Query("id_giaymoi") int id_giaymoi,
                                                       @Query("id_tk") String id_tk,
                                                       @Query("nam") String nam);

    @POST("api/XuLyGiayMoi/duyettuchoibaocaokequacuochop")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyettuchoibaocaokequacuochop(@Header("Authorization") String token,
                                                                @Field("id") int id,
                                                                @Field("id_noidung") int id_noidung,
                                                                @Field("id_vb") int id_vb,
                                                                @Field("ykien") String ykien,
                                                                @Field("type") int type,
                                                                @Field("nam") String nam);

    @POST("api/XuLyGiayMoi/chuyenTiepKeQuaBaoCaoCuocHop")
    @FormUrlEncoded
    Observable<Response<Boolean>> chuyenTiepKeQuaBaoCaoCuocHop(@Header("Authorization") String token,
                                                               @Field("id") int id,
                                                               @Field("id_noidung") int id_noidung,
                                                               @Field("id_vb") int id_vb,
                                                               @Field("idCanBoNhans") String idCanBoNhans,
                                                               @Field("noiDungChuyen") String noiDungChuyen,
                                                               @Field("nam") String nam);

    // báo cáo kết quả cuộc họp
    @GET("api/XuLyGiayMoi/getallbaocaokequacuochop")
    Observable<Response<ArrayList<BaoCaoKetQuaCuocHop>>> getallbaocaokequacuochop(@Header("Authorization") String token,
                                                                                  @Query("nam") String nam,
                                                                                  @Query("id_tk") String id_tk,
                                                                                  @Query("status") int status,
                                                                                  @Query("page") int page,
                                                                                  @Query("size") int size);

    @GET("api/XuLyGiayMoi/countbaocaokequacuochop")
    Observable<Response<Integer>> countbaocaokequacuochop(@Header("Authorization") String token,
                                                          @Query("nam") String nam,
                                                          @Query("id_tk") String id_tk,
                                                          @Query("status") int status);

    @GET("api/XuLyGiayMoi/getdetailbaocaokequacuochop")
    Observable<Response<BaoCaoKetQuaCuocHop>> getdetailbaocaokequacuochop(@Header("Authorization") String token,
                                                                          @Query("id") int id_vb,
                                                                          @Query("id_tk") String id_tk,
                                                                          @Query("nam") String nam);

    // báo cáo kết quả cuộc họp đã gửi đi
    @GET("api/XuLyGiayMoi/getallbaocaosoanthaodagui")
    Observable<Response<ArrayList<BaoCaoKetQuaDaGuiDi>>> getallbaocaosoanthaodagui(@Header("Authorization") String token,
                                                                                   @Query("nam") String nam,
                                                                                   @Query("id_tk") String id_tk,
                                                                                   @Query("page") int page,
                                                                                   @Query("size") int size);

    @GET("api/XuLyGiayMoi/countbaocaosoanthaodagui")
    Observable<Response<Integer>> countbaocaosoanthaodagui(@Header("Authorization") String token,
                                                           @Query("nam") String nam,
                                                           @Query("id_tk") String id_tk);

    // Van ban di trinh ky 1 : Văn bản trình ký | 2: Văn bản đã trả lại | 3 : Văn bản đã ký
    @GET("api/VanBanDi/getallvanban")
    Observable<Response<ArrayList<DataVanBanDi>>> getallvanban(@Header("Authorization") String token,
                                                               @Query("nam") String nam,
                                                               @Query("id_tk") String id_tk,
                                                               @Query("trang_thai") int trang_thai,
                                                               @Query("page") int page,
                                                               @Query("size") int size);

    @GET("api/VanBanDi/getvanbanbyid")
    Observable<Response<DataVanBanDi>> getvanbanbyid(@Header("Authorization") String token,
                                                     @Query("id") int id,
                                                     @Query("id_tk") String id_tk,
                                                     @Query("nam") String nam);

    @GET("api/VanBanDi/getdetailvanbanbyid")
    Observable<Response<DetailVanBanDi>> getdetailvanbanbyid(@Header("Authorization") String token,
                                                             @Query("id") int id,
                                                             @Query("id_tk") String id_tk,
                                                             @Query("nam") String nam);

    @GET("api/VanBanDi/countvanban")
    Observable<Response<Integer>> countvanban(@Header("Authorization") String token,
                                              @Query("nam") String nam,
                                              @Query("id_tk") String id_tk,
                                              @Query("trang_thai") int trang_thai);

    @POST("api/VanBanDi/dongyvanban")
    @FormUrlEncoded
    Observable<Response<Boolean>> dongyvanban(@Header("Authorization") String token,
                                              @Field("id_tk") String id_tk,
                                              @Field("id_vb") int id_vb,
                                              @Field("nam") String nam);

    @POST("api/VanBanDi/tralaivanban")
    @FormUrlEncoded
    Observable<Response<Boolean>> tralaivanban(@Header("Authorization") String token,
                                               @Field("id_tk") String id_tk,
                                               @Field("id_vb") int id_vb,
                                               @Field("y_kien") String y_kien);

    // VAN BAN DI DA TRINH KY
    @GET("api/VanBanDi/getVBtrinhky")
    Observable<Response<ArrayList<VanBanDaTrinhKy>>> getVBtrinhky(@Header("Authorization") String token,
                                                                  @Query("id_tk") String id_tk,
                                                                  @Query("nam") String nam,
                                                                  @Query("page") int page,
                                                                  @Query("size") int size);

    @GET("api/VanBanDi/countVBtrinhky")
    Observable<Response<Integer>> countVBtrinhky(@Header("Authorization") String token,
                                                 @Query("nam") String nam,
                                                 @Query("id_tk") String id_tk);

    // tra lai van ban truong phong

    @POST("api/VanBanDi/tralaivanban_tp")
    @FormUrlEncoded
    Observable<Response<Boolean>> tralaivanban_tp(@Header("Authorization") String token,
                                                  @Field("nam") String nam,
                                                  @Field("id_tk") String id_tk,
                                                  @Field("id_vb") int id_vb,
                                                  @Field("y_kien") String y_kien);

    @POST("api/VanBanDi/guilen")
    @FormUrlEncoded
    Observable<Response<Boolean>> guilen(@Header("Authorization") String token,
                                         @Field("nam") String nam,
                                         @Field("id_vb") int id_vb,
                                         @Field("id_tk") String id_tk,
                                         @Field("id_ld") String id_ld,
                                         @Field("lanhdaoso_xem") ArrayList<String> id_ld1,
                                         @Field("y_kien") String y_kien);

    //get dsPhongBan_SoluongvanBan
    @GET("api/VanBanDi/getDSPhongban_solgvb")
    Observable<Response<ArrayList<DetailDanhSachVanBanSoThamMuuTrinhThanhPho>>> getDSPhongban_solgvb(@Header("Authorization") String token,
                                                                                                     @Query("id_tk") String id_tk,
                                                                                                     @Query("nam") String nam,
                                                                                                     @Query("tungay") String tungay,
                                                                                                     @Query("denngay") String denngay,
                                                                                                     @Query("mapb") int mapb);

    //get getVBdi_thammuu
    @GET("api/VanBanDi/getVBdi_thammuu")
    Observable<Response<ArrayList<DetailDanhSachVanBanSoThamMuuTrinhThanhPho>>> getVBdi_thammuu(@Header("Authorization") String token,
                                                                                                @Query("id_tk") String id_tk,
                                                                                                @Query("nam") String nam,
                                                                                                @Query("tungay") String tungay,
                                                                                                @Query("denngay") String denngay,
                                                                                                @Query("mapb") int mapb);


    //van ban di xem de biet

    @GET("api/VanBanDi/getallvanbanxemdebiet")
    Observable<Response<ArrayList<DataVanBanDi>>> getallvanbanxemdebiet(@Header("Authorization") String token,
                                                                        @Query("nam") String nam,
                                                                        @Query("id_tk") String id_tk,
                                                                        @Query("page") int page,
                                                                        @Query("size") int size);

    @GET("api/VanBanDi/coutvanbanxemdebiet")
    Observable<Response<Integer>> coutvanbanxemdebiet(@Header("Authorization") String token,
                                                      @Query("nam") String nam,
                                                      @Query("id_tk") String id_tk);

    //van ban di da xu ly
    @GET("api/VanBanDi/getVBdi_daxuly_tp")
    Observable<Response<ArrayList<VanBanDiDaXuly>>> getVBdi_daxuly_tp(@Header("Authorization") String token,
                                                                      @Query("id_tk") String id_tk,
                                                                      @Query("nam") String nam,
                                                                      @Query("page") int page,
                                                                      @Query("size") int size);

    @GET("api/VanBanDi/countVBdi_daxuly_tp")
    Observable<Response<Integer>> countVBdi_daxuly_tp(@Header("Authorization") String token,
                                                      @Query("id_tk") String id_tk,
                                                      @Query("nam") String nam);

    //van ban di chưa xu ly
    @GET("api/VanBanDi/getVBdi_chuaxuly_tp")
    Observable<Response<ArrayList<VanBanDiChuaXuLy>>> getVBdi_chuaxuly_tp(@Header("Authorization") String token,
                                                                          @Query("id_tk") String id_tk,
                                                                          @Query("nam") String nam,
                                                                          @Query("page") int page,
                                                                          @Query("size") int size);

    @GET("api/VanBanDi/countVBdi_chuaxuly_tp")
    Observable<Response<Integer>> countVBdi_chuaxuly_tp(@Header("Authorization") String token,
                                                        @Query("id_tk") String id_tk,
                                                        @Query("nam") String nam);


    //get danh sach giay moi cua phong
    @GET("api/VanBanDi/getDSGM_cuaPhong")
    Observable<Response<ArrayList<GiayMoiCuaPhong>>> getDSGM_cuaPhong(@Header("Authorization") String token,
                                                                      @Query("id_tk") String id_tk,
                                                                      @Query("nam") String nam,
                                                                      @Query("kieu") int kieu,
                                                                      @Query("page") int page,
                                                                      @Query("size") int size);

    @GET("api/VanBanDi/countDSGM_cuaPhong")
    Observable<Response<Integer>> countDSGM_cuaPhong(@Header("Authorization") String token,
                                                     @Query("id_tk") String id_tk,
                                                     @Query("nam") String nam,
                                                     @Query("kieu") int kieu);


    //get lich hop lanh dao
    @GET("api/VanBanDi/getlichhoplanhdao")
    Observable<Response<DetailLichHop>> getlichhoplanhdao(@Header("Authorization") String token,
                                                          @Query("id_tk") String id_tk,
                                                          @Query("nam") String nam);

    //Văn bản đi - DSVB Chờ số của sở
    @GET("api/VanBanDi/getDSVB_ChoSo_CuaSo")
    Observable<Response<ArrayList<DeatailDauSoCuaSo>>> getDSVB_ChoSo_CuaSo(@Header("Authorization") String token,
                                                                           @Query("id_tk") String id_tk,
                                                                           @Query("nam") String nam,
                                                                           @Query("page") int page,
                                                                           @Query("size") int size);

    @GET("api/VanBanDi/nhapVB_suaVB")
    Observable<Response<DSVB_ChoSoCuaSo>> nhapVB_suaVB(@Header("Authorization") String token,
                                                       @Query("id_tk") String id_tk,
                                                       @Query("id_vb") int id_vb,
                                                       @Query("nam") String nam);

    @GET("api/VanBanDi/countVBdi_ChoSo")
    Observable<Response<Integer>> countVBdi_ChoSo(@Header("Authorization") String token,
                                                  @Query("id_tk") String id_tk,
                                                  @Query("nam") String nam);


    // trao doi thong tin noi bo  0:daxem 1:moi
    @GET("api/TraoDoiThongTinNoiBo/getallvanban")
    Observable<Response<ArrayList<TraoDoiThongTinNoiBo>>> getallvanbanThongTinNoiBo(@Header("Authorization") String token,
                                                                                    @Query("nam") String nam,
                                                                                    @Query("id_tk") String id_tk,
                                                                                    @Query("trangthai") int trangthai,
                                                                                    @Query("page") int page,
                                                                                    @Query("size") int size);

    @GET("api/TraoDoiThongTinNoiBo/countallvanban")
    Observable<Response<Integer>> countvanbanThongTinNoiBo(@Header("Authorization") String token,
                                                           @Query("nam") String nam,
                                                           @Query("id_tk") String id_tk,
                                                           @Query("trangthai") int trang_thai);

    @GET("api/TraoDoiThongTinNoiBo/getvanbanbyid")
    Observable<Response<TraoDoiThongTinNoiBoDetail>> getdetailvanbanbyidThongTinNoiBo(@Header("Authorization") String token,
                                                                                      @Query("id_vb") int id_vb,
                                                                                      @Query("id_tk") String id_tk,
                                                                                      @Query("nam") String nam);

    //van ban gui di

    @GET("api/TraoDoiThongTinNoiBo/getallvanbanguidi")
    Observable<Response<ArrayList<VanBanGuiDi>>> getallvanbanguidi(@Header("Authorization") String token,
                                                                   @Query("nam") String nam,
                                                                   @Query("id_tk") String id_tk,
                                                                   @Query("page") int page,
                                                                   @Query("size") int size);

    @GET("api/TraoDoiThongTinNoiBo/countallvanbanguidi")
    Observable<Response<Integer>> countallvanbanguidi(@Header("Authorization") String token,
                                                      @Query("nam") String nam,
                                                      @Query("id_tk") String id_tk);

    @GET("api/TraoDoiThongTinNoiBo/getvanbanguidibyid")
    Observable<Response<DetailVanBanGuiDi>> getvanbanguidibyid(@Header("Authorization") String token,
                                                               @Query("id_vb") int id_vb,
                                                               @Query("id_tk") String id_tk,
                                                               @Query("nam") String nam);

    //DauViecNoBoSo trang thai:1
    @GET("api/DauViecNoBoSo/countalldauviec")
    Observable<Response<Integer>> countalldauviec(@Header("Authorization") String token,
                                                  @Query("nam") String nam,
                                                  @Query("id_tk") String id_tk,
                                                  @Query("trang_thai") int trang_thai);

    @GET("api/DauViecNoBoSo/gettkdauviec")
    Observable<Response<DetailDauViecCuaSo>> gettkdauviec(@Header("Authorization") String token,
                                                          @Query("id_tk") String id_tk,
                                                          @Query("nam") String nam);


    @GET("api/DauViecNoBoSo/getAllDauViecNew")
    Observable<Response<ArrayList<DauViecChoXuLy>>> getalldauviec(@Header("Authorization") String token,
                                                                  @Query("nam") String nam,
                                                                  @Query("trang_thai") int trang_thai);

    @POST("api/DauViecNoBoSo/duyetdauviec")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetdauviec(@Header("Authorization") String token,
                                               @Field("id") int id,
                                               @Field("id_tk") String id_tk,
                                               @Field("id_pho_giam_doc") int id_phogiamdoc,
                                               @Field("noidung_pho_giam_doc") String noidung_pho_giam_doc,
                                               @Field("id_phong_chu_tri") int id_phong_chu_tri,
                                               @Field("phong_phoi_hops") String phong_phoi_hops,
                                               @Field("noidung_phoi_hop") String noidung_phoi_hop,
                                               @Field("han_xu_ly") String han_xu_ly,
                                               @Field("nam") String nam);


    @GET("api/DauViecNoBoSo/getChiTietDauViec")
    Observable<Response<DetailDauViec1>> getdauviecdetail(@Header("Authorization") String token,
                                                          @Query("id") int id,
                                                          @Query("id_tk") String id_tk,
                                                          @Query("nam") String nam);

    @POST("api/DauViecNoBoSo/hoanThanhDauViec")
    @FormUrlEncoded
    Observable<Response<Boolean>> hoanThanhDauViec(@Header("Authorization") String token,
                                                   @Field("id") int id,
                                                   @Field("noiDungHoanThanh") String noiDungHoanThanh,
                                                   @Field("nam") String nam);

    @GET("api/DauViecNoBoSo/getChiTietDauViecPHCT")
    Observable<Response<DetailDauViecPhongCT>> getChiTietDauViecPHCT(@Header("Authorization") String token,
                                                                     @Query("id") int id,
                                                                     @Query("nam") String nam);

    @GET("api/DauViecNoBoSo/getChiTietDauViecPH")
    Observable<Response<DetailDauViecPhongCT>> getChiTietDauViecPH(@Header("Authorization") String token,
                                                                   @Query("id") int id,
                                                                   @Query("nam") String nam);

    @POST("api/DauViecNoBoSo/hoanThanhDauViecPHCT")
    @FormUrlEncoded
    Observable<Response<Boolean>> hoanThanhDauViecPHCT(@Header("Authorization") String token,
                                                       @Field("id") int id,
                                                       @Field("noiDungHoanThanh") String noiDungHoanThanh,
                                                       @Field("nam") String nam);

    // dau viecNoiboso
    @POST("api/DauViecNoBoSo/dongygiahan")
    @FormUrlEncoded
    Observable<Response<Boolean>> dongygiahan(@Header("Authorization") String token,
                                              @Field("id") int id,
                                              @Field("id_vb") int id_vb,
                                              @Field("id_tk") String id_tk,
                                              @Field("ngay_dexuat") String ngay_dexuat,
                                              @Field("ykien_chidao") String ykien_chidao,
                                              @Field("nam") String nam);

    @POST("api/DauViecNoBoSo/tuchoigiahan")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuchoigiahan(@Header("Authorization") String token,
                                               @Field("id") int id,
                                               @Field("id_vb") int id_vb,
                                               @Field("id_tk") String id_tk,
                                               @Field("ngay_dexuat") String ngay_dexuat,
                                               @Field("ly_do") String ly_do,
                                               @Field("nam") String nam);


    //dau viec de xuat trang thai 0:de xuat gia han cho xu ly ; 1:de xuat gia han da xu ly
    @GET("api/DauViecNoBoSo/getalldauviecdexuatgiahan")
    Observable<Response<ArrayList<DauViecDeXuat>>> getalldauviecdexuatgiahan(@Header("Authorization") String token,
                                                                             @Query("nam") String nam,
                                                                             @Query("id_tk") String id_tk,
                                                                             @Query("trang_thai") int trang_thai,
                                                                             @Query("page") int page,
                                                                             @Query("size") int size);

    @GET("api/DauViecNoBoSo/coutalldauviecdexuatgiahan")
    Observable<Response<Integer>> coutalldauviecdexuatgiahan(@Header("Authorization") String token,
                                                             @Query("nam") String nam,
                                                             @Query("id_tk") String id_tk,
                                                             @Query("trang_thai") int trang_thai);

    // dau viec qua han cua phong
    @GET("api/DauViecNoBoSo/getAllDauViecQuaHanPhong")
    Observable<Response<ArrayList<DanhSachDauViecQuaHanCuaPhong>>> getAllDauViecQuaHanPhong(@Header("Authorization") String token,
                                                                                            @Query("nam") String nam);

    //dau viec phong chu tri cho xu ly
    @GET("api/DauViecNoBoSo/getAllDauViecPhongChuTriChoXuLy")
    Observable<Response<ArrayList<DanhSachDauViecPhongChuTriChoXuLy>>> getAllDauViecPhongChuTriChoXuLy(@Header("Authorization") String token,
                                                                                                       @Query("nam") String nam,
                                                                                                       @Query("isPhoPhongPP") boolean isPhoPhongPP);

    @POST("api/DauViecNoBoSo/duyetDauViecPhongChuTriChoXuLyTPPH")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetDauViecPhongChuTriChoXuLyTPPP(@Header("Authorization") String token,
                                                                     @Field("id") int id,
                                                                     @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                     @Field("tenChuyenVienPhoiHops") String tenChuyenVienPhoiHops,
                                                                     @Field("hanXuLy") String hanXuLy,
                                                                     @Field("nam") String nam);

    //dau viec phong chu tri cho xu ly chuyen vien
    @GET("api/DauViecNoBoSo/getAllDauViecPhongChuTriChoXuLyCV")
    Observable<Response<ArrayList<PhongChuTriChuyenVienChoXuLy>>> getAllDauViecPhongChuTriChoXuLyCV(@Header("Authorization") String token,
                                                                                                    @Query("nam") String nam,
                                                                                                    @Query("isChuyenVienPH") boolean isChuyenVienPH);

    @POST("api/DauViecNoBoSo/deXuatGiaHanDauViecPhongChuTriChoXuLyCV")
    @FormUrlEncoded
    Observable<Response<Boolean>> deXuatGiaHanDauViecPhongChuTriChoXuLyCV(@Header("Authorization") String token,
                                                                          @Field("id") int id,
                                                                          @Field("ngayDeXuat") String ngayDeXuat,
                                                                          @Field("lyDoDeXuat") String lyDoDeXuat,
                                                                          @Field("nam") String nam);

    //dau viec phong phoi hop cho xu ly chuyen vien
    @GET("api/DauViecNoBoSo/getAllDauViecPhongPhoHopChoXuLyCV")
    Observable<Response<ArrayList<PhongChuTriChuyenVienChoXuLy>>> getAllDauViecPhongPhoiHopCV(@Header("Authorization") String token,
                                                                                              @Query("nam") String nam,
                                                                                              @Query("isChuyenVienPH") boolean isChuyenVienPH);

    // dau viec hoan thanh cho lanh dao phong phe duyet
    @GET("api/DauViecNoBoSo/getAllDauViecHoanThanhChoLDDuyet")
    Observable<Response<ArrayList<DauViecHoanThanhChoLanhDaoPhongDuyet>>> getAllDauViecHoanThanhChoLDDuyet(@Header("Authorization") String token,
                                                                                                           @Query("nam") String nam,
                                                                                                           @Query("page") int page,
                                                                                                           @Query("size") int size);

    @POST("api/DauViecNoBoSo/tuChoiDauViecHoanThanhChoLDDuyet")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiDauViecHoanThanhChoLDDuyet(@Header("Authorization") String token,
                                                                   @Field("id") int id,
                                                                   @Field("noiDungTraLai") String noiDungTraLai,
                                                                   @Field("nam") String nam);

    @POST("api/DauViecNoBoSo/duyetDauViecHoanThanhChoLDDuyet")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetDauViecHoanThanhChoLDDuyet(@Header("Authorization") String token,
                                                                  @Field("id") int id,
                                                                  @Field("nam") String nam);

    @GET("api/DauViecNoBoSo/countDauViecHoanThanhChoLDDuyet")
    Observable<Response<Integer>> countDauViecHoanThanhChoLDDuyet(@Header("Authorization") String token,
                                                                  @Query("nam") String nam);

    @POST("api/DauViecNoBoSo/duyetDauViecPhongChuTriChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetDauViecPhongChuTriChoXuLy(@Header("Authorization") String token,
                                                                 @Field("id") int id,
                                                                 @Field("idPhoPhong") int idPhoPhong,
                                                                 @Field("tenPhoPhong") String tenPhoPhong,
                                                                 @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                                 @Field("tenPhoPhongPhoiHops") String tenPhoPhongPhoiHops,
                                                                 @Field("idChuyenVien") int idChuyenVien,
                                                                 @Field("tenChuyenVien") String tenChuyenVien,
                                                                 @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                 @Field("tenChuyenVienPhoiHops") String tenChuyenVienPhoiHops,
                                                                 @Field("hanXuLy") String hanXuLy);

    //dau viec phong phoi hop cho xu ly
    @GET("api/DauViecNoBoSo/getAllDauViecPhongPhoHopChoXuLy")
    Observable<Response<ArrayList<DanhSachDauViecPhongChuTriChoXuLy>>> getAllDauViecPhongPhoHopChoXuLy(@Header("Authorization") String token,
                                                                                                       @Query("nam") String nam,
                                                                                                       @Query("isPhoPhongPP") boolean isPhoPhongPP);

    @POST("api/DauViecNoBoSo/duyetDauViecPhongPhoHopChoXuLyTPPH")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetDauViecPhongPhoHopChoXuLyTPPP(@Header("Authorization") String token,
                                                                     @Field("id") int id,
                                                                     @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                     @Field("tenChuyenVienPhoiHops") String tenChuyenVienPhoiHops,
                                                                     @Field("hanXuLy") String hanXuLy,
                                                                     @Field("nam") String nam);

    @POST("api/DauViecNoBoSo/duyetDauViecPhongPhoHopChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetDauViecPhongPhoHopChoXuLy(@Header("Authorization") String token,
                                                                 @Field("id") int id,
                                                                 @Field("idPhoPhong") int idPhoPhong,
                                                                 @Field("tenPhoPhong") String tenPhoPhong,
                                                                 @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                                 @Field("tenPhoPhongPhoiHops") String tenPhoPhongPhoiHops,
                                                                 @Field("idChuyenVien") int idChuyenVien,
                                                                 @Field("tenChuyenVien") String tenChuyenVien,
                                                                 @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                 @Field("tenChuyenVienPhoiHops") String tenChuyenVienPhoiHops,
                                                                 @Field("hanXuLy") String hanXuLy,
                                                                 @Field("nam") String nam);

    // dau viec phong chu tri da chi dao chua ht
    @GET("api/DauViecNoBoSo/getAllDauViecPhongChuTriDaChiDao")
    Observable<Response<ArrayList<DanhSachDauViecPhongChuTriDaChiDaoChuaHT>>> getAllDauViecPhongChuTriDaChiDao(@Header("Authorization") String token,
                                                                                                               @Query("nam") String nam,
                                                                                                               @Query("isPhoPhongPP") boolean isPhoPhongPP);

    @POST("api/DauViecNoBoSo/duyetDauViecPhongChuTriDaChiDaoTPPH")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetDauViecPhongChuTriDaChiDaoTPPH(@Header("Authorization") String token,
                                                                      @Field("id") int id,
                                                                      @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                      @Field("tenChuyenVienPhoiHops") String tenChuyenVienPhoiHops,
                                                                      @Field("hanXuLy") String hanXuLy,
                                                                      @Field("nam") String nam);

    @POST("api/DauViecNoBoSo/duyetDauViecPhongChuTriDaChiDao")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetDauViecPhongChuTriDaChiDao(@Header("Authorization") String token,
                                                                  @Field("id") int id,
                                                                  @Field("idPhoPhong") int idPhoPhong,
                                                                  @Field("tenPhoPhong") String tenPhoPhong,
                                                                  @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                                  @Field("tenPhoPhongPhoiHops") String tenPhoPhongPhoiHops,
                                                                  @Field("idChuyenVien") int idChuyenVien,
                                                                  @Field("tenChuyenVien") String tenChuyenVien,
                                                                  @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                  @Field("tenChuyenVienPhoiHops") String tenChuyenVienPhoiHops,
                                                                  @Field("hanXuLy") String hanXuLy,
                                                                  @Field("nam") String nam);

    //dau viec phong phoi hop da chi dao chua ht
    @GET("api/DauViecNoBoSo/getAllDauViecPhongPhoHopDaChiDao")
    Observable<Response<ArrayList<DanhSachDauViecPhongChuTriDaChiDaoChuaHT>>> getAllDauViecPhongPhoHopDaChiDao(@Header("Authorization") String token,
                                                                                                               @Query("nam") String nam,
                                                                                                               @Query("isPhoPhongPP") boolean isPhoPhongPP);

    @POST("api/DauViecNoBoSo/duyetDauViecPhongPhoHopDaChiDaoTPPH")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetDauViecPhongPhoHopDaChiDaoTPPH(@Header("Authorization") String token,
                                                                      @Field("id") int id,
                                                                      @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                      @Field("tenChuyenVienPhoiHops") String tenChuyenVienPhoiHops,
                                                                      @Field("hanXuLy") String hanXuLy,
                                                                      @Field("nam") String nam);

    @POST("api/DauViecNoBoSo/duyetDauViecPhongPhoHopDaChiDao")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetDauViecPhongPhoHopDaChiDao(@Header("Authorization") String token,
                                                                  @Field("id") int id,
                                                                  @Field("idPhoPhong") int idPhoPhong,
                                                                  @Field("tenPhoPhong") String tenPhoPhong,
                                                                  @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                                  @Field("tenPhoPhongPhoiHops") String tenPhoPhongPhoiHops,
                                                                  @Field("idChuyenVien") int idChuyenVien,
                                                                  @Field("tenChuyenVien") String tenChuyenVien,
                                                                  @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                  @Field("tenChuyenVienPhoiHops") String tenChuyenVienPhoiHops,
                                                                  @Field("hanXuLy") String hanXuLy,
                                                                  @Field("nam") String nam);

    //DauViecNoBoSo kien nghi hdnd
    @GET("api/DauViecNoBoSo/getallkiennghi")
    Observable<Response<ArrayList<DSKienNghiHDND>>> getallkiennghi(@Header("Authorization") String token,
                                                                   @Query("nam") String nam,
                                                                   @Query("id_tk") String id_tk,
                                                                   @Query("page") int page,
                                                                   @Query("size") int size);

    @GET("api/DauViecNoBoSo/countallkiennghi")
    Observable<Response<Integer>> countallkiennghi(@Header("Authorization") String token,
                                                   @Query("nam") String nam,
                                                   @Query("id_tk") String id_tk);

    //DauViecNoBoSo ds tai liệu họp của phòng
    @GET("api/DauViecNoBoSo/getalltaileuhopphong")
    Observable<Response<ArrayList<DSKienNghiHDND>>> getalltaileuhopphong(@Header("Authorization") String token,
                                                                         @Query("nam") String nam,
                                                                         @Query("id_tk") String id_tk,
                                                                         @Query("page") int page,
                                                                         @Query("size") int size);

    @GET("api/DauViecNoBoSo/countalltaileuhopphong")
    Observable<Response<Integer>> countalltaileuhopphong(@Header("Authorization") String token,
                                                         @Query("nam") String nam,
                                                         @Query("id_tk") String id_tk);

    //DauViecNoBoSo ds tai liệu họp của tổng hợp
    @GET("api/DauViecNoBoSo/getalltaileuhop")
    Observable<Response<ArrayList<DSKienNghiHDND>>> getalltaileuhop(@Header("Authorization") String token,
                                                                    @Query("nam") String nam,
                                                                    @Query("id_tk") String id_tk,
                                                                    @Query("page") int page,
                                                                    @Query("size") int size);


    @GET("api/DauViecNoBoSo/countalltaileuhop")
    Observable<Response<Integer>> countalltaileuhop(@Header("Authorization") String token,
                                                    @Query("nam") String nam,
                                                    @Query("id_tk") String id_tk);

    //quan ly can bo ke hoach cong tac tuan
    @GET("api/KeHoachCongTacDanhGia/gettkkehoachcongtactuan")
    Observable<Response<ArrayList<KeHoachCongTacTuan>>> gettkkehoachcongtactuan(@Header("Authorization") String token,
                                                                                @Query("id_tk") String id_tk,
                                                                                @Query("tuan") int tuan,
                                                                                @Query("nam") String nam);

    //quan ly can bo ke hoach cong tac thang
    @GET("api/KeHoachCongTacDanhGia/gettkkehoachcongtacthang")
    Observable<Response<ArrayList<KeHoachCongTacTuan>>> gettkkehoachcongtacthang(@Header("Authorization") String token,
                                                                                 @Query("id_tk") String id_tk,
                                                                                 @Query("thang") int thang,
                                                                                 @Query("nam") String nam);

    // giam doc so tu nhan xet
    @GET("api/KeHoachCongTacDanhGia/getdanhgiaGD")
    Observable<Response<ArrayList<DanhGiaGiamDoc>>> getdanhgiaGD(@Header("Authorization") String token,
                                                                 @Query("id_tk") String id_tk,
                                                                 @Query("thang") int thang);

    @POST("api/KeHoachCongTacDanhGia/GD_tuchamdiem")
    @FormUrlEncoded
    Observable<Response<Boolean>> GD_tuchamdiem(@Header("Authorization") String token,
                                                @Field("idcb") String idcb,
                                                @Field("thang") int thang,
                                                @Field("tucham_A") String tucham_A,
                                                @Field("tucham_B_1") String tucham_B_1,
                                                @Field("tucham_B_2") String tucham_B_2,
                                                @Field("tucham_B_3") String tucham_B_3,
                                                @Field("tucham_B_4") String tucham_B_4,
                                                @Field("tucham_B_5") String tucham_B_5,
                                                @Field("tucham_B_6") String tucham_B_6,
                                                @Field("tucham_C_1") String tucham_C_1,
                                                @Field("tucham_C_2") String tucham_C_2,
                                                @Field("tucham_C_3") String tucham_C_3,
                                                @Field("tucham_C_4") String tucham_C_4,
                                                @Field("tucham_C_5") String tucham_C_5,
                                                @Field("tucham_C_6") String tucham_C_6,
                                                @Field("tucham_C_7") String tucham_C_7,
                                                @Field("tucham_D") String tucham_D,
                                                @Field("danhgia") String danhgia,
                                                @Field("tunhanxet") String tunhanxet);

    //get van ban den tong the kieu: 0 danh sách tổng thể, 1 danh sách công tác đảng, 2 danh sách giấy mời, 3 Văn bản STC chủ trì, (THỐNG KÊ VB THEO NƠI ĐẾN kieu = 0 ) 4 - Văn bản Sở Tài chính Chủ Trì, 5 - Văn bản Thành ủy Hà Nội, 6 - Văn bản UBND Thành phố Hà Nội, 7 - Thông Báo kết luận ,8 - Văn bản HĐND Thành Phố HN,9 - Văn bản Khác, 10 - Văn bản Tổ công tác
    //loai 0 tất cả, 1 Văn bản mới nhập, 2 Đã giải quyết
    @GET("api/VanBanDen/getallvbdentongthe")
    Observable<Response<ArrayList<DetailVanBanDenTongThe>>> getallvbdentongthe(@Header("Authorization") String token,
                                                                               @Query("id_tk") String id_tk,
                                                                               @Query("kieu") int kieu,
                                                                               @Query("loai") int loai,
                                                                               @Query("nam") String nam,
                                                                               @Query("page") int page,
                                                                               @Query("size") int size);

    @GET("api/VanBanDen/countvbden")
    Observable<Response<Integer>> countvbden(@Header("Authorization") String token,
                                             @Query("id_tk") String id_tk,
                                             @Query("kieu") int kieu,
                                             @Query("loai") int loai,
                                             @Query("nam") String nam);

    //get van ban di tong the kieu  0:ds van ban cua so 1:ds giay moi cua so
    //LOAI 0:TAT CA  1:DAGUI MAIL  2:CHƯA GUI MAIL
    @GET("api/VanBanDi/getallvbditongthe")
    Observable<Response<ArrayList<DetailVanBanDiTongThe>>> getallvbditongthe(@Header("Authorization") String token,
                                                                             @Query("id_tk") String id_tk,
                                                                             @Query("loai") int loai,
                                                                             @Query("kieu") int kieu,
                                                                             @Query("nam") String nam,
                                                                             @Query("page") int page,
                                                                             @Query("size") int size);

    @GET("api/VanBanDi/countvbditongthe")
    Observable<Response<Integer>> countvbditongthe(@Header("Authorization") String token,
                                                   @Query("id_tk") String id_tk,
                                                   @Query("kieu") int kieu,
                                                   @Query("loai") int loai,
                                                   @Query("nam") String nam);

    //in so luu tru van ban di
    //loaiso
    //0-khác, 1 -giấy mời
    @GET("api/VanBanDi/getVBdi_InSoLuuTru")
    Observable<Response<ArrayList<InSoLuuTruVanbanDi>>> getVBdi_InSoLuuTru(@Header("Authorization") String token,
                                                                           @Query("id_tk") String id_tk,
                                                                           @Query("nam") String nam,
                                                                           @Query("soditu") String soditu,
                                                                           @Query("sodiden") String sodiden,
                                                                           @Query("tungay") String tungay,
                                                                           @Query("denngay") String denngay,
                                                                           @Query("loaiso") int loaiso,
                                                                           @Query("ngaymoitu") String ngaymoitu,
                                                                           @Query("ngaymoiden") String ngaymoiden,
                                                                           @Query("page") int page,
                                                                           @Query("size") int size);

    @GET("api/VanBanDi/countVBdi_Insoluutru")
    Observable<Response<Integer>> countVBdi_Insoluutru(@Header("Authorization") String token,
                                                       @Query("id_tk") String id_tk,
                                                       @Query("nam") String nam,
                                                       @Query("soditu") String soditu,
                                                       @Query("sodiden") String sodiden,
                                                       @Query("tungay") String tungay,
                                                       @Query("denngay") String denngay,
                                                       @Query("loaiso") int loaiso,
                                                       @Query("ngaymoitu") String ngaymoitu,
                                                       @Query("ngaymoiden") String ngaymoiden);


    // in so luu tru van ban den
    @GET("api/VanBanDen/getInSoLuuTru_den")
    Observable<Response<ArrayList<InSoLuuTruVanBanDen>>> getInSoLuuTru_den(@Header("Authorization") String token,
                                                                           @Query("idUser") String idUser,
                                                                           @Query("nam") String nam,
                                                                           @Query("sodentu") String sodentu,
                                                                           @Query("sodenden") String sodenden,
                                                                           @Query("ngaynhaptu") String ngaynhaptu,
                                                                           @Query("ngaynhapden") String ngaynhapden,
                                                                           @Query("page") int page,
                                                                           @Query("size") int size);

    @GET("api/VanBanDen/countInSoLuuTru_den")
    Observable<Response<Integer>> countInSoLuuTru_den(@Header("Authorization") String token,
                                                      @Query("idUser") String idUser,
                                                      @Query("nam") String nam,
                                                      @Query("sodentu") String sodentu,
                                                      @Query("sodenden") String sodenden,
                                                      @Query("ngaynhaptu") String ngaynhaptu,
                                                      @Query("ngaynhapden") String ngaynhapden);


    //get thống kê kết quả công tác tuần, tháng trong sở
    @GET("api/KeHoachCongTacDanhGia/gettkdanhgiakequanhiemvuthang")
    Observable<Response<ArrayList<ThongKeKetQuaCongTacThang>>> gettkdanhgiakequanhiemvuthang(@Header("Authorization") String token,
                                                                                             @Query("id_tk") String id_tk,
                                                                                             @Query("nam") String nam,
                                                                                             @Query("thang_start") int thang_start,
                                                                                             @Query("thang_end") int thang_end,
                                                                                             @Query("idphong") int idphong,
                                                                                             @Query("id_canbo") int id_canbo,
                                                                                             @Query("mucdanhgia") int mucdanhgia);

    @GET("api/KeHoachCongTacDanhGia/gettkdanhgiakequanhiemvu")
    Observable<Response<ArrayList<ThongKeKetQuaCongTacTuan>>> gettkdanhgiakequanhiemvu(@Header("Authorization") String token,
                                                                                       @Query("id_tk") String id_tk,
                                                                                       @Query("nam") String nam,
                                                                                       @Query("tuan_start") int tuan_start,
                                                                                       @Query("tuan_end") int tuan_end,
                                                                                       @Query("idphong") int idphong,
                                                                                       @Query("id_canbo") int id_canbo);

    //danh muc
    @GET("api/DanhMuc/getAllCanBoByIdPhongBan")
    Observable<Response<ArrayList<CanBoByidPhongBan>>> getAllCanBoByIdPhongBan(@Header("Authorization") String token,
                                                                               @Query("id") int id,
                                                                               @Query("nam") String nam);

    @GET("api/DanhMuc/getAllMucDanhGia")
    Observable<Response<ArrayList<MucDanhGia>>> getAllMucDanhGia(@Header("Authorization") String token);

    @GET("api/DanhMuc/getAllPhongBanChiCuc")
    Observable<Response<ArrayList<MucDanhGia>>> getAllPhongBanChiCuc(@Header("Authorization") String token);

    @GET("api/DanhMuc/getphongKeHoachDanhGia")
    Observable<Response<ArrayList<PhongBanKeHoachDanhGia>>> getphongKeHoachDanhGia(@Header("Authorization") String token,
                                                                                   @Query("nam") String nam);

    @GET("api/DanhMuc/getCanBoKeHoachDanhGia")
    Observable<Response<ArrayList<CanBoByidPhongBan>>> getCanBoKeHoachDanhGia(@Header("Authorization") String token,
                                                                              @Query("idphong") int id,
                                                                              @Query("nam") String nam);

    //van ban di - ds van ban cua phong
    @GET("api/VanBanDi/getDSVB_cuaPhong")
    Observable<Response<ArrayList<DSVBCuaPhong>>> getDSVB_cuaPhong(@Header("Authorization") String token,
                                                                   @Query("id_tk") String id_tk,
                                                                   @Query("nam") String nam,
                                                                   @Query("page") int page,
                                                                   @Query("size") int size);

    @GET("api/VanBanDi/countDSVB_cuaPhong")
    Observable<Response<Integer>> countDSVB_cuaPhong(@Header("Authorization") String token,
                                                     @Query("id_tk") String id_tk,
                                                     @Query("nam") String nam);

    //    duyet dsvb gia han giai quyet tk truong phong
    @POST("api/XulyVanBan/duyetVBGiaHanGiaQuyetCB")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBGiaHanGiaQuyetCB(@Header("Authorization") String token,
                                                          @Field("id") int id,
                                                          @Field("lyDo") String ly_do,
                                                          @Field("hanGiaQuyet") String hanGiaQuyet,
                                                          @Field("nam") String nam);

    @POST("api/XulyVanBan/duyetVBGiaHanGiaQuyetTP")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBGiaHanGiaQuyetTP(@Header("Authorization") String token,
                                                          @Field("id") int id,
                                                          @Field("lyDo") String ly_do,
                                                          @Field("hanGiaQuyet") String hanGiaQuyet,
                                                          @Field("nam") String nam);

    //van ban den-bao cao tong hop
    @GET("api/DanhMuc/getphongBcaoTongHop")
    Observable<Response<ArrayList<PhongBaoCaoTongHop>>> getphongBcaoTongHop(@Header("Authorization") String token,
                                                                            @Query("id_tk") String id_tk,
                                                                            @Query("nam") String nam);

    @GET("api/VanBanDen/getBaoCaoTongHop")
    Observable<Response<ArrayList<BaoCaoTongHop>>> getBaoCaoTongHop(@Header("Authorization") String token,
                                                                    @Query("id_tk") String id_tk,
                                                                    @Query("nam") String nam,
                                                                    @Query("ngaybd") String ngaybd,
                                                                    @Query("ngaykt") String ngaykt,
                                                                    @Query("idphong") int idphong,
                                                                    @Query("vbtt") int vbtt);

    @GET("api/VanBanDen/getDetailVanBanDauRa")
    Observable<Response<DetailBaoCaoTongHop>> getDetailVanBanDauRa(@Header("Authorization") String token,
                                                                   @Query("id") int id,
                                                                   @Query("nam") String nam);

    // XLVB - de xuat cong viec phoi hop cho duyet
    @GET("api/XulyVanBan/getDetailVBChuyenVienChuTriXuLy")
    Observable<Response<DetailDeXuatCongViecPhoiHopChoDuyet>> getDetailVBChuyenVienChuTriXuLy(@Header("Authorization") String token,
                                                                                              @Query("id") int id,
                                                                                              @Query("nam") String nam);

    // Xu Ly GIaY MoI - GM giao phong phoi hop da chi dao
    @GET("api/XuLyGiayMoi/getAllGMGiaoPhongPhoiHopDaChiDao")
    Observable<Response<ArrayList<GMGiaoPhongPhoiHopDaChiDao>>> getAllGMGiaoPhongPhoiHopDaChiDao(@Header("Authorization") String token,
                                                                                                 @Query("nam") String nam,
                                                                                                 @Query("page") int page,
                                                                                                 @Query("size") int size);

    @GET("api/XuLyGiayMoi/countAllGMGiaoPhongPhoiHopDaChiDao")
    Observable<Response<Integer>> countAllGMGiaoPhongPhoiHopDaChiDao(@Header("Authorization") String token,
                                                                     @Query("nam") String nam);

    //KẾ HOẠCH CÔNG TÁC - ĐÁNH GIÁ - Phân loại công chức của phòng theo tháng
    @GET("api/KeHoachCongTacDanhGia/gettkkehoachcongtacthang_phong")
    Observable<Response<ArrayList<PhanLoaiCongChucCuaPhongTheoThang>>> gettkkehoachcongtacthang_phong(@Header("Authorization") String token,
                                                                                                      @Query("id_tk") String id_tk,
                                                                                                      @Query("thang") int thang,
                                                                                                      @Query("idphong") int idphong,
                                                                                                      @Query("nam") String nam);

    // Nhận xét, chấm điểm công việc tuần của cấp dưới
    @GET("api/KeHoachCongTacDanhGia/getDanhSachCB_CTtuan")
    Observable<Response<ArrayList<NhanXetChamDiemCongViecTuanCuaCapDuoi>>> getDanhSachCB_CTtuan(@Header("Authorization") String token,
                                                                                                @Query("id_tk") String id_tk,
                                                                                                @Query("nam") String nam,
                                                                                                @Query("tuan") int tuan,
                                                                                                @Query("idphong") int idphong);

    @GET("api/KeHoachCongTacDanhGia/getDanhSachChuyenVien_CTtuan")
    Observable<Response<ArrayList<NhanXetChamDiemCongViecTuanCuaCapDuoi>>> getDanhSachChuyenVien_CTtuan(@Header("Authorization") String token,
                                                                                                        @Query("id_tk") String id_tk,
                                                                                                        @Query("nam") String nam,
                                                                                                        @Query("tuan") int tuan,
                                                                                                        @Query("idphong") int idphong);

    //quan ly dau viec-danh sach dau viec phong phoi hop
    @GET("api/DauViecNoBoSo/getAllDauViecPhongPhoiHop")
    Observable<Response<ArrayList<DanhSachDauViecPhongPhoiHop>>> getAllDauViecPhongPhoiHop(@Header("Authorization") String token,
                                                                                           @Query("nam") String nam);

    //quan ly dau viec-danh sach dau viec phong chu tri
    @GET("api/DauViecNoBoSo/getAllDauViecPhongChuTri")
    Observable<Response<ArrayList<DanhSachDauViecPhongPhoiHop>>> getAllDauViecPhongChuTri(@Header("Authorization") String token,
                                                                                          @Query("nam") String nam);

    // XLVB -  VB phó phòng phối hợp chờ xử lý:
    @GET("api/XulyVanBan/getAllVBPhoPhongPhoiHopChoXuLy")
    Observable<Response<ArrayList<VBPhoPhongPhoiHopChoXL>>> getAllVBPhoPhongPhoiHopChoXuLy(@Header("Authorization") String token,
                                                                                           @Query("nam") String nam,
                                                                                           @Query("page") int page,
                                                                                           @Query("size") int size);

    @GET("api/XulyVanBan/countAllVBPhoPhongPhoiHopChoXuLy")
    Observable<Response<Integer>> countAllVBPhoPhongPhoiHopChoXuLy(@Header("Authorization") String token,
                                                                   @Query("nam") String nam);

    @POST("api/XulyVanBan/duyetVBPhoPhongPhoiHopChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBPhoPhongPhoiHopChoXuLy(@Header("Authorization") String token,
                                                                @Field("id") int id,
                                                                @Field("idPhoPhong") int idPhoPhong,
                                                                @Field("idPhoiHop") String idPhoiHop,
                                                                @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                @Field("chiDaoChuTri") String chiDaoChuTri,
                                                                @Field("hanXuLy") String hanXuLy,
                                                                @Field("nam") String nam);

    //VAN BAN PHOI HOP CHO XULY
    @GET("api/XulyVanBan/getAllVBPhoiHopChoXuLy")
    Observable<Response<ArrayList<VanBanPhoiHopChoXuLy>>> getAllVBPhoiHopChoXuLy(@Header("Authorization") String token,
                                                                                 @Query("nam") String nam,
                                                                                 @Query("page") int page,
                                                                                 @Query("size") int size);

    @GET("api/XulyVanBan/countAllVBPhoiHopChoXuLy")
    Observable<Response<Integer>> countAllVBPhoiHopChoXuLy(@Header("Authorization") String token,
                                                           @Query("nam") String nam);

    //tuchoi
    @POST("api/XulyVanBan/tuChoiVBPhoiHopDaChiDao")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiVBPhoiHopDaChiDao(@Header("Authorization") String token,
                                                          @Field("idPhoiHop") int idPhoiHop,
                                                          @Field("noiDungTuChoi") String noiDungTuChoi,
                                                          @Field("nam") String nam);

    //VĂN BẢN ĐI - Văn bản chủ trì đã xử lý
    @DELETE("api/VanBanDi/xoavb_trinhky")
    Observable<Response<Boolean>> xoavb_trinhky(@Header("Authorization") String token,
                                                @Query("idvb") int idvb,
                                                @Query("nam") String nam);

    //XỬ LÝ VĂN BẢN - Số lượng văn bản giao phòng phối hợp
    @POST("api/XulyVanBan/tuChoiVBPhongPhoiHop")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiVBPhongPhoiHop(@Header("Authorization") String token,
                                                       @Field("id") int id,
                                                       @Field("noiDungTuChoi") String noiDungTuChoi,
                                                       @Field("nam") String nam);

    //XỬ LÝ GIẤY MỜI - GM phối hợp chờ xử lý:
    @GET("api/XuLyGiayMoi/getAllGMPhoiHopChoXuLy")
    Observable<Response<ArrayList<GMPhoiHopChoXL>>> getAllGMPhoiHopChoXuLy(@Header("Authorization") String token,
                                                                           @Query("nam") String nam,
                                                                           @Query("page") int page,
                                                                           @Query("size") int size);

    @GET("api/XuLyGiayMoi/countAllGMPhoiHopChoXuLy")
    Observable<Response<Integer>> countAllGMPhoiHopChoXuLy(@Header("Authorization") String token,
                                                           @Query("nam") String nam);

    //get lich cong tac
    @GET("api/XuLyGiayMoi/getLichCongTac")
    Observable<Response<ArrayList<LichCongTac>>> getLichCongTac(@Header("Authorization") String token,
                                                                @Query("id_tk") String id_tk,
                                                                @Query("soTuan") int soTuan,
                                                                @Query("nam") String nam,
                                                                @Query("id_lanhdao") int id_lanhdao);

    //dau viec hoan thanh bi tra lai
    @GET("api/DauViecNoBoSo/getAllDauViecHoanThanhBiTraLai")
    Observable<Response<ArrayList<DauViecHoanThanhBiTraLai>>> getAllDauViecHoanThanhBiTraLai(@Header("Authorization") String token,
                                                                                             @Query("nam") String nam,
                                                                                             @Query("page") int page,
                                                                                             @Query("size") int size);

    @GET("api/DauViecNoBoSo/countAllDauViecHoanThanhBiTraLai")
    Observable<Response<Integer>> countAllDauViecHoanThanhBiTraLai(@Header("Authorization") String token,
                                                                   @Query("nam") String nam);

    @POST("api/DauViecNoBoSo/duyetDauViecHoanThanhBiTraLai")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetDauViecHoanThanhBiTraLai(@Header("Authorization") String token,
                                                                @Field("id") int id,
                                                                @Field("idLanhDao") int idLanhDao,
                                                                @Field("hanVanBan") String hanVanBan,
                                                                @Field("nam") String nam);

    @POST("api/DauViecNoBoSo/traLaiDauViecHoanThanhBiTraLai")
    @FormUrlEncoded
    Observable<Response<Boolean>> traLaiDauViecHoanThanhBiTraLai(@Header("Authorization") String token,
                                                                 @Field("id") int id,
                                                                 @Field("noiDungTraLai") String noiDungTraLai,
                                                                 @Field("nam") String nam);

    //XỬ LÝ VĂN BẢN - Văn bản phối hợp chờ xử lý:
    @GET("api/XulyVanBan/getAllVBPhoiHopChoXuLyCV")
    Observable<Response<ArrayList<VanBanPhoiHopChoXuLyChuyenVien>>> getAllVBPhoiHopChoXuLyCV(@Header("Authorization") String token,
                                                                                             @Query("nam") String nam,
                                                                                             @Query("page") int page,
                                                                                             @Query("size") int size);

    @GET("api/XulyVanBan/countAllVBPhoiHopChoXuLyCV")
    Observable<Response<Integer>> countAllVBPhoiHopChoXuLyCV(@Header("Authorization") String token,
                                                             @Query("nam") String nam);

    //XỬ LÝ GIẤY MỚI - GM giao phối hợp chờ xử lý:
    @GET("api/XuLyGiayMoi/getAllGMPhoiHopChoXuLyCV")
    Observable<Response<ArrayList<GMGiaoPhoiHopChoXuLy>>> getAllGMPhoiHopChoXuLyCV(@Header("Authorization") String token,
                                                                                   @Query("nam") String nam,
                                                                                   @Query("page") int page,
                                                                                   @Query("size") int size);

    @GET("api/XuLyGiayMoi/countAllGMPhoiHopChoXuLyCV")
    Observable<Response<Integer>> countAllGMPhoiHopChoXuLyCV(@Header("Authorization") String token,
                                                             @Query("nam") String nam);

    //QUẢN LÝ ĐẦU VIỆC NỘI BỘ SỞ - DSĐV đề xuất gia hạn chờ duyệt chuyenvien
    @GET("api/DauViecNoBoSo/getAllDauViecDeXuatGiaHanChoDuyetCV")
    Observable<Response<ArrayList<DeXuatGiaHanChoDuyet>>> getAllDauViecDeXuatGiaHanChoDuyetCV(@Header("Authorization") String token,
                                                                                              @Query("nam") String nam,
                                                                                              @Query("trangThai") int trangThai,
                                                                                              @Query("page") int page,
                                                                                              @Query("size") int size);

    @GET("api/DauViecNoBoSo/countAllDauViecDeXuatGiaHanChoDuyetCV")
    Observable<Response<Integer>> countAllDauViecDeXuatGiaHanChoDuyetCV(@Header("Authorization") String token,
                                                                        @Query("nam") String nam,
                                                                        @Query("trangThai") int trangThai);

    @POST("api/DauViecNoBoSo/deXuatGiaHanDauViecChoDuyetCV")
    @FormUrlEncoded
    Observable<Response<Boolean>> deXuatGiaHanDauViecChoDuyetCV(@Header("Authorization") String token,
                                                                @Field("id") int id,
                                                                @Field("ngayDeXuat") String ngayDeXuat,
                                                                @Field("lyDoDeXuat") String lyDoDeXuat,
                                                                @Field("idDeXuat") int idDeXuat,
                                                                @Field("nam") String nam);

    //QUẢN LÝ ĐẦU VIỆC NỘI BỘ SỞ -  Đầu việc phòng phối hợp chờ xử lý(CV PH):
    @GET("api/DauViecNoBoSo/getAllDauViecPhongPhoHopChoXuLyCV")
    Observable<Response<ArrayList<PhongChuTriChuyenVienChoXuLy>>> getAllDauViecPhongPhoHopChoXuLyCV(@Header("Authorization") String token,
                                                                                                    @Query("nam") String nam,
                                                                                                    @Query("isChuyenVienPH") boolean isChuyenVienPH);

    //XỬ LÝ VĂN BẢN - Phân loại văn bản công tác Đảng:
    @GET("api/XulyVanBan/getAllVanBanCTDChuaPhanLoai")
    Observable<Response<ArrayList<PhanLoaiVanBanCongTacDang>>> getAllVanBanCTDChuaPhanLoai(@Header("Authorization") String token,
                                                                                           @Query("nam") String nam,
                                                                                           @Query("page") int page,
                                                                                           @Query("size") int size);

    @GET("api/XulyVanBan/countAllVanBanCTDChuaPhanLoai")
    Observable<Response<Integer>> countAllVanBanCTDChuaPhanLoai(@Header("Authorization") String token,
                                                                @Query("nam") String nam);

    @POST("api/XulyVanBan/themNoidungVBCTDChuaPhanLoai")
    @FormUrlEncoded
    Observable<Response<Boolean>> themNoidungVBCTDChuaPhanLoai(@Header("Authorization") String token,
                                                               @Field("id") int id,
                                                               @Field("hanNoiDung") String hanNoiDung,
                                                               @Field("noiDung") String noiDung,
                                                               @Field("nam") String nam);

    @POST("api/XulyVanBan/duyetVBCTDChuaPhanLoai")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBCTDChuaPhanLoai(@Header("Authorization") String token,
                                                         @Field("id") int id,
                                                         @Field("idGiamDoc") int idGiamDoc,
                                                         @Field("idPhoGiamDoc") int idPhoGiamDoc,
                                                         @Field("idPhongChuTri") int idPhongChuTri,
                                                         @Field("hanGiaiQuyet") String hanGiaiQuyet,
                                                         @Field("idPhongPhoiHop") String idPhongPhoiHop,
                                                         @Field("chiDaoGiamDoc") String chiDaoGiamDoc,
                                                         @Field("chiDaoPhoGiamDoc") String chiDaoPhoGiamDoc,
                                                         @Field("chiChuTri") String chiChuTri,
                                                         @Field("isVBQT") int isVBQT,
                                                         @Field("nam") String nam);

    //XỬ LÝ VĂN BẢN - Văn bản các phòng chuyển lại:
    @GET("api/XulyVanBan/getAllVanBanChuyenLai")
    Observable<Response<ArrayList<VanBanCacPhongChuyenLai>>> getAllVanBanChuyenLai(@Header("Authorization") String token,
                                                                                   @Query("nam") String nam,
                                                                                   @Query("page") int page,
                                                                                   @Query("size") int size);

    @GET("api/XulyVanBan/countAllVanBanChuyenLai")
    Observable<Response<Integer>> countAllVanBanChuyenLai(@Header("Authorization") String token,
                                                          @Query("nam") String nam);

    @POST("api/XulyVanBan/duyetAllVanBanChuyenLai")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetAllVanBanChuyenLai(@Header("Authorization") String token,
                                                          @Field("id") int id,
                                                          @Field("idGiamDoc") int idGiamDoc,
                                                          @Field("idPhoGiamDoc") int idPhoGiamDoc,
                                                          @Field("idPhongChuTri") int idPhongChuTri,
                                                          @Field("hanGiaiQuyet") String hanGiaiQuyet,
                                                          @Field("idPhongPhoiHop") String idPhongPhoiHop,
                                                          @Field("chiDaoGiamDoc") String chiDaoGiamDoc,
                                                          @Field("chiDaoPhoGiamDoc") String chiDaoPhoGiamDoc,
                                                          @Field("chiChuTri") String chiChuTri,
                                                          @Field("isVBQT") int isVBQT,
                                                          @Field("nam") String nam);

    @POST("api/VanBanDen/xoaVbden_tongthe")
    @FormUrlEncoded
    Observable<Response<Boolean>> xoaVbden_tongthe(@Header("Authorization") String token,
                                                   @Field("idvb") int idvb,
                                                   @Field("nam") String nam);

    //[TRUONG CHI CUC] Văn bản đã chỉ đạo (chưa hoàn thành):
    @GET("api/XulyVanBan/getAllVBDaChiDaoChuaHoanThanhCC")
    Observable<Response<ArrayList<VanBanDaChiDaoChuaHT>>> getAllVBDaChiDaoChuaHoanThanhCC(@Header("Authorization") String token,
                                                                                          @Query("nam") String nam,
                                                                                          @Query("page") int page,
                                                                                          @Query("size") int size);

    @GET("api/XulyVanBan/countAllVBDaChiDaoChuaHoanThanhCC")
    Observable<Response<Integer>> countAllVBDaChiDaoChuaHoanThanhCC(@Header("Authorization") String token,
                                                                    @Query("nam") String nam);

    @POST("api/XulyVanBan/duyetVBDaChiDaoChuaHoanThanhCC")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBDaChiDaoChuaHoanThanhCC(@Header("Authorization") String token,
                                                                 @Field("nam") String nam,
                                                                 @Field("id") int id,
                                                                 @Field("idChiCuc") int idChiCuc,
                                                                 @Field("idChiCucPho") int idChiCucPho,
                                                                 @Field("idTruongPhong") int idTruongPhong,
                                                                 @Field("idTruongPhongPPs") String idTruongPhongPPs,
                                                                 @Field("chiDaoChiCucPho") String chiDaoChiCucPho,
                                                                 @Field("chiDaoChuTri") String chiDaoChuTri,
                                                                 @Field("hanGiaiQuyet") String hanGiaiQuyet);

    //[TRUONG CHI CUC] Số lượng văn bản giao chi cục phó chủ trì
    @GET("api/XulyVanBan/getAllVBGiaoPhongChuTriCC")
    Observable<Response<ArrayList<SoLuongVanBanGiaoChiCucPhoChuTri>>> getAllVBGiaoPhongChuTriCC(@Header("Authorization") String token,
                                                                                                @Query("nam") String nam,
                                                                                                @Query("page") int page,
                                                                                                @Query("size") int size);

    @GET("api/XulyVanBan/countAllVBGiaoPhongChuTriCC")
    Observable<Response<Integer>> countAllVBGiaoPhongChuTriCC(@Header("Authorization") String token,
                                                              @Query("nam") String nam);

    //[TRUONG CHI CUC] Văn bản đã chỉ đạo (STC phối hợp)
    @GET("api/XulyVanBan/getAllVBDaChiDaoSTCPhoiHopCC")
    Observable<Response<ArrayList<VanBanDaChiDaoChuaHT>>> getAllVBDaChiDaoSTCPhoiHopCC(@Header("Authorization") String token,
                                                                                       @Query("nam") String nam,
                                                                                       @Query("page") int page,
                                                                                       @Query("size") int size);

    @GET("api/XulyVanBan/countAllVBDaChiDaoSTCPhoiHopCC")
    Observable<Response<Integer>> countAllVBDaChiDaoSTCPhoiHopCC(@Header("Authorization") String token,
                                                                 @Query("nam") String nam);

    @POST("api/XulyVanBan/duyetVBDaChiDaoSTCPhoiHopCC")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBDaChiDaoSTCPhoiHopCC(@Header("Authorization") String token,
                                                              @Field("nam") String nam,
                                                              @Field("id") int id,
                                                              @Field("idChiCuc") int idChiCuc,
                                                              @Field("idChiCucPho") int idChiCucPho,
                                                              @Field("idTruongPhong") int idTruongPhong,
                                                              @Field("idTruongPhongPPs") String idTruongPhongPPs,
                                                              @Field("chiDaoChiCucPho") String chiDaoChiCucPho,
                                                              @Field("chiDaoChuTri") String chiDaoChuTri,
                                                              @Field("hanGiaiQuyet") String hanGiaiQuyet);

    //[Xu Ly Giay Moi ]TRUONG CHI CUC] Giấy mời chờ xử lý
    @GET("api/XuLyGiayMoi/getAllGMPhongChoXuLyCC")
    Observable<Response<ArrayList<GiayMoiChoXuLy>>> getAllGMPhongChoXuLyCC(@Header("Authorization") String token,
                                                                           @Query("nam") String nam,
                                                                           @Query("page") int page,
                                                                           @Query("size") int size);

    @GET("api/XuLyGiayMoi/countAllGMPhongChoXuLyCC")
    Observable<Response<Integer>> countAllGMPhongChoXuLyCC(@Header("Authorization") String token,
                                                           @Query("nam") String nam);

    @POST("api/XuLyGiayMoi/duyetVBPhongChoXuLyCC")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBPhongChoXuLyCC(@Header("Authorization") String token,
                                                        @Field("nam") String nam,
                                                        @Field("id") int id,
                                                        @Field("idChiCuc") int idChiCuc,
                                                        @Field("idChiCucPho") int idChiCucPho,
                                                        @Field("idTruongPhong") int idTruongPhong,
                                                        @Field("idTruongPhongPPs") String idTruongPhongPPs,
                                                        @Field("chiDaoChiCucPho") String chiDaoChiCucPho,
                                                        @Field("chiDaoChuTri") String chiDaoChuTri,
                                                        @Field("hanGiaiQuyet") String hanGiaiQuyet);

    //[Xu Ly Giay Moi ]TRUONG CHI CUC] Giấy mời đã xử lý
    @GET("api/XuLyGiayMoi/getAllGMDaXuLyCC")
    Observable<Response<ArrayList<GiayMoiChoXuLy>>> getAllGMDaXuLyCC(@Header("Authorization") String token,
                                                                     @Query("nam") String nam,
                                                                     @Query("page") int page,
                                                                     @Query("size") int size);

    @GET("api/XuLyGiayMoi/countAllGMDaXuLyCC")
    Observable<Response<Integer>> countAllGMDaXuLyCC(@Header("Authorization") String token,
                                                     @Query("nam") String nam);

    @POST("api/XuLyGiayMoi/duyetGMDaXuLyCC")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetGMDaXuLyCC(@Header("Authorization") String token,
                                                  @Field("nam") String nam,
                                                  @Field("id") int id,
                                                  @Field("idChiCuc") int idChiCuc,
                                                  @Field("idChiCucPho") int idChiCucPho,
                                                  @Field("idTruongPhong") int idTruongPhong,
                                                  @Field("idTruongPhongPPs") String idTruongPhongPPs,
                                                  @Field("chiDaoChiCucPho") String chiDaoChiCucPho,
                                                  @Field("chiDaoChuTri") String chiDaoChuTri,
                                                  @Field("hanGiaiQuyet") String hanGiaiQuyet);

    //[VAN BAN DI ] [TRUONG CHI CUC]Văn bản chủ trì chờ xử lý:
    @GET("api/VanBanDi/getAllVBChuTriChoXuLyCC")
    Observable<Response<ArrayList<VanBanChuTriChoXuLyCC>>> getAllVBChuTriChoXuLyCC(@Header("Authorization") String token,
                                                                                   @Query("nam") String nam,
                                                                                   @Query("page") int page,
                                                                                   @Query("size") int size);

    @GET("api/VanBanDi/countAllVBChuTriChoXuLyCC")
    Observable<Response<Integer>> countAllVBChuTriChoXuLyCC(@Header("Authorization") String token,
                                                            @Query("nam") String nam);

    @POST("api/VanBanDi/guiLenVBChuTriChoXuLyCC")
    @FormUrlEncoded
    Observable<Response<Boolean>> guiLenVBChuTriChoXuLyCC(@Header("Authorization") String token,
                                                          @Field("nam") String nam,
                                                          @Field("id") int id,
                                                          @Field("idLanhDao") int idLanhDao,
                                                          @Field("yKien") String yKien);

    @POST("api/VanBanDi/traLaiVBChuTriChoXuLyCC")
    @FormUrlEncoded
    Observable<Response<Boolean>> traLaiVBChuTriChoXuLyCC(@Header("Authorization") String token,
                                                          @Field("nam") String nam,
                                                          @Field("id") int id,
                                                          @Field("yKien") String yKien);

    //[VAN BAN DI ] [TRUONG CHI CUC] Văn bản chủ trì đã xử lý:
    @GET("api/VanBanDi/getAllVBChuTriDaXuLyCC")
    Observable<Response<ArrayList<VanBanChuTriDaXuLyCC>>> getAllVBChuTriDaXuLyCC(@Header("Authorization") String token,
                                                                                 @Query("nam") String nam,
                                                                                 @Query("page") int page,
                                                                                 @Query("size") int size);

    @GET("api/VanBanDi/countAllVBChuTriDaXuLyCC")
    Observable<Response<Integer>> countAllVBChuTriDaXuLyCC(@Header("Authorization") String token,
                                                           @Query("nam") String nam);

    @DELETE("api/VanBanDi/DeleteVBChuTriDaXuLyCC")
    Observable<Response<Boolean>> DeleteVBChuTriDaXuLyCC(@Header("Authorization") String token,
                                                         @Query("nam") String nam,
                                                         @Query("idvb") int idvb);

    //[DAU VIEC  ] [TRUONG CHI CUC] Đầu việc phòng chủ trì chờ xử lý
    @GET("api/DauViecNoBoSo/getAllDauViecPhongChuTriChoXuLyCC")
    Observable<Response<ArrayList<DauViecPhongChuTriChoXuLy>>> getAllDauViecPhongChuTriChoXuLyCC(@Header("Authorization") String token,
                                                                                                 @Query("nam") String nam);

    @POST("api/DauViecNoBoSo/duyetDauViecPhongChuTriChoXuLyCC")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetDauViecPhongChuTriChoXuLyCC(@Header("Authorization") String token,
                                                                   @Field("nam") String nam,
                                                                   @Field("id") int id,
                                                                   @Field("idPhongBan") int idPhongBan,
                                                                   @Field("tenPhongBan") String tenPhongBan,
                                                                   @Field("idPhongPhoiHops") String idPhongPhoiHops,
                                                                   @Field("tenPhongPhoiHop") String tenPhongPhoiHop,
                                                                   @Field("hanXuLy") String hanXuLy);

    //[DAU VIEC ] [TRUONG CHI CUC] Đầu việc phòng phối hợp chờ xử lý
    @GET("api/DauViecNoBoSo/getAllDauViecPhongPhoHopChoXuLyCC")
    Observable<Response<ArrayList<DauViecPhongPhoiHopChoXuLyCC>>> getAllDauViecPhongPhoHopChoXuLyCC(@Header("Authorization") String token,
                                                                                                    @Query("nam") String nam);

    @POST("api/DauViecNoBoSo/duyetDauViecPhongPhoHopChoXuLyCC")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetDauViecPhongPhoHopChoXuLyCC(@Header("Authorization") String token,
                                                                   @Field("nam") String nam,
                                                                   @Field("id") int id,
                                                                   @Field("idPhongPhoiHops") String idPhongPhoiHops,
                                                                   @Field("tenPhongPhoiHops") String tenPhongPhoiHops,
                                                                   @Field("hanXuLy") String hanXuLy);

    //[DAU VIEC ] [TRUONG CHI CUC]  DS đầu việc phòng chủ trì đã xử lý
    @GET("api/DauViecNoBoSo/getAllDauViecPhongChuTriDaXuLyCC")
    Observable<Response<ArrayList<DSDauViecPhongChuTriDaXuLyCC>>> getAllDauViecPhongChuTriDaXuLyCC(@Header("Authorization") String token,
                                                                                                   @Query("nam") String nam);

    @POST("api/DauViecNoBoSo/duyetDauViecPhongChuTriDaXuLyCC")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetDauViecPhongChuTriDaXuLyCC(@Header("Authorization") String token,
                                                                  @Field("nam") String nam,
                                                                  @Field("id") int id,
                                                                  @Field("idPhongBan") int idPhongBan,
                                                                  @Field("tenPhongBan") String tenPhongBan,
                                                                  @Field("idPhongPhoiHops") String idPhongPhoiHops,
                                                                  @Field("tenPhongPhoiHop") String tenPhongPhoiHop,
                                                                  @Field("hanXuLy") String hanXuLy);

    //[DAU VIEC ] [TRUONG CHI CUC] DS đầu việc phòng phối hợp đã xử lý
    @GET("api/DauViecNoBoSo/getAllDauViecPhongPhoHopDaXuLyCC")
    Observable<Response<ArrayList<DauViecPhongPhoiHopChoXuLyCC>>> getAllDauViecPhongPhoHopDaXuLyCC(@Header("Authorization") String token,
                                                                                                   @Query("nam") String nam);

    @POST("api/DauViecNoBoSo/duyetDauViecPhongPhoHopDaXuLyCC")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetDauViecPhongPhoHopDaXuLyCC(@Header("Authorization") String token,
                                                                  @Field("nam") String nam,
                                                                  @Field("id") int id,
                                                                  @Field("idPhongPhoiHops") String idPhongPhoiHops,
                                                                  @Field("tenPhongPhoiHops") String tenPhongPhoiHops,
                                                                  @Field("hanXuLy") String hanXuLy);

    //[ VĂN BẢN ĐƠN VỊ CẤP HAI ] [TRUONG CHI CUC] Danh sách văn bản tổng thể
    @GET("api/VanBanDen/getAllVBTongTheDonViCapHai")
    Observable<Response<ArrayList<VanBanTongTheDonViCapHai>>> getAllVBTongTheDonViCapHai(@Header("Authorization") String token,
                                                                                         @Query("nam") String nam,
                                                                                         @Query("page") int page,
                                                                                         @Query("size") int size);

    @GET("api/VanBanDen/countAllVBTongTheDonViCapHai")
    Observable<Response<Integer>> countAllVBTongTheDonViCapHai(@Header("Authorization") String token,
                                                               @Query("nam") String nam);

    //[ VĂN BẢN ĐƠN VỊ CẤP HAI ] [TRUONG CHI CUC] Văn bản chờ chỉ đạo
    @GET("api/VanBanDen/getAllVBChoChiDaoDonViCapHai")
    Observable<Response<ArrayList<VanBanChoChiDao>>> getAllVBChoChiDaoDonViCapHai(@Header("Authorization") String token,
                                                                                  @Query("nam") String nam,
                                                                                  @Query("page") int page,
                                                                                  @Query("size") int size);

    @GET("api/VanBanDen/countAllVBChoChiDaoDonViCapHai")
    Observable<Response<Integer>> countAllVBChoChiDaoDonViCapHai(@Header("Authorization") String token,
                                                                 @Query("nam") String nam);

    @POST("api/VanBanDen/duyetVBChoChiDaoDonViCapHai")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBChoChiDaoDonViCapHai(@Header("Authorization") String token,
                                                              @Field("nam") String nam,
                                                              @Field("id") int id,
                                                              @Field("idLanhDao") int idLanhDao,
                                                              @Field("tenLanhDao") String tenLanhDao,
                                                              @Field("idPhongChuTri") int idPhongChuTri,
                                                              @Field("tenPhongChuTri") String tenPhongChuTri,
                                                              @Field("idPhongPhoiHops") String idPhongPhoiHops,
                                                              @Field("tenPhongPhoiHops") String tenPhongPhoiHops,
                                                              @Field("hanXuLy") String hanXuLy);

    //[ VĂN BẢN ĐƠN VỊ CẤP HAI ] [TRUONG CHI CUC] Văn bản đã chỉ đạo (Phòng chưa xử lý)
    @GET("api/VanBanDen/getAllVBDaChiDaoPhongChuaXuLyDonViCapHai")
    Observable<Response<ArrayList<VanBanDaChiDaoPhongChuaXuLy>>> getAllVBDaChiDaoPhongChuaXuLyDonViCapHai(@Header("Authorization") String token,
                                                                                                          @Query("nam") String nam,
                                                                                                          @Query("page") int page,
                                                                                                          @Query("size") int size);

    @GET("api/VanBanDen/countAllVBDaChiDaoPhongChuaXuLyDonViCapHai")
    Observable<Response<Integer>> countAllVBDaChiDaoPhongChuaXuLyDonViCapHai(@Header("Authorization") String token,
                                                                             @Query("nam") String nam);

    @POST("api/VanBanDen/duyetVBDaChiDaoPhongChuaXuLyDonViCapHai")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBDaChiDaoPhongChuaXuLyDonViCapHai(@Header("Authorization") String token,
                                                                          @Field("nam") String nam,
                                                                          @Field("id") int id,
                                                                          @Field("idLanhDao") int idLanhDao,
                                                                          @Field("tenLanhDao") String tenLanhDao,
                                                                          @Field("idPhongChuTri") int idPhongChuTri,
                                                                          @Field("tenPhongChuTri") String tenPhongChuTri,
                                                                          @Field("idPhongPhoiHops") String idPhongPhoiHops,
                                                                          @Field("tenPhongPhoiHops") String tenPhongPhoiHops,
                                                                          @Field("hanXuLy") String hanXuLy);

    //[ VĂN BẢN ĐI ĐƠN VỊ CẤP HAI ] [TRUONG CHI CUC] Danh sách văn bản đi - Danh sách văn bản chờ số
    @GET("api/VanBanDi/getAllVBDiDonViCapHai")
    Observable<Response<ArrayList<DanhSachVanBanDi>>> getAllVBDiDonViCapHai(@Header("Authorization") String token,
                                                                            @Query("nam") String nam,
                                                                            @Query("trangthai") int trangthai,
                                                                            @Query("page") int page,
                                                                            @Query("size") int size);

    @GET("api/VanBanDi/countAllVBDiDonViCapHai")
    Observable<Response<Integer>> countAllVBDiDonViCapHai(@Header("Authorization") String token,
                                                          @Query("nam") String nam,
                                                          @Query("trangthai") int trangthai);

    @POST("api/VanBanDi/duyetVBDiDonViCapHai")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBDiDonViCapHai(@Header("Authorization") String token,
                                                       @Field("nam") String nam,
                                                       @Field("id") int id,
                                                       @Field("ngayVBDi") String ngayVBDi);

    @DELETE("api/VanBanDi/deleteVBDiDonViCapHai")
    Observable<Response<Boolean>> deleteVBDiDonViCapHai(@Header("Authorization") String token,
                                                        @Query("nam") String nam,
                                                        @Query("idvb") int idvb
    );

    //
    @POST("api/XulyVanBan/tuChoiTPVBPhongChuTriChoXuLy")
    @FormUrlEncoded
    Observable<Response<Boolean>> tuChoiTPVBPhongChuTriChoXuLy(@Header("Authorization") String token,
                                                               @Field("nam") String nam,
                                                               @Field("id") int id,
                                                               @Field("noiDungTuChoi") String noiDungTuChoi,
                                                               @Field("ghiChu") String ghiChu);

    //[Quyền =10,11] Tổng số văn bản giao phòng xử lý: Số lượng văn bản giao phòng cấp 2 chủ trì
    @GET("api/XulyVanBan/getAllVBGiaoPhongC2CC")
    Observable<Response<ArrayList<SoLuongVanBanGiaoChiCucPhoChuTri>>> getAllVBGiaoPhongC2CC(@Header("Authorization") String token,
                                                                                            @Query("nam") String nam,
                                                                                            @Query("page") int page,
                                                                                            @Query("size") int size);

    @GET("api/XulyVanBan/countAllVBGiaoPhongC2CC")
    Observable<Response<Integer>> countAllVBGiaoPhongC2CC(@Header("Authorization") String token,
                                                          @Query("nam") String nam);

    //VU BANG LAM [LV 2 ]- Văn bản chờ chỉ đạo - Văn bản đã chỉ đạo (Phòng chưa xử lý)
    @GET("api/VanBanDen/getAllVBChoChiDaoDonViCapHaiPhong")
    Observable<Response<ArrayList<VanBanChoChiDaoLV2>>> getAllVBChoChiDaoDonViCapHaiPhong(@Header("Authorization") String token,
                                                                                          @Query("nam") String nam,
                                                                                          @Query("page") int page,
                                                                                          @Query("size") int size);

    @GET("api/VanBanDen/countAllVBChoChiDaoDonViCapHaiPhong")
    Observable<Response<Integer>> countAllVBChoChiDaoDonViCapHaiPhong(@Header("Authorization") String token,
                                                                      @Query("nam") String nam);

    @POST("api/VanBanDen/duyetVBChoChiDaoDonViCapHaiPhong")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBChoChiDaoDonViCapHaiPhong(@Header("Authorization") String token,
                                                                   @Field("nam") String nam,
                                                                   @Field("id") int id,
                                                                   @Field("idPhongChuTri") int idPhongChuTri,
                                                                   @Field("tenPhongChuTri") String tenPhongChuTri,
                                                                   @Field("idPhongPhoiHops") String idPhongPhoiHops,
                                                                   @Field("tenPhongPhoiHops") String tenPhongPhoiHops,
                                                                   @Field("hanXuLy") String hanXuLy);

    @GET("api/VanBanDen/getAllVBDaChiDaoPhongChuaXuLyDonViCapHaiPhong")
    Observable<Response<ArrayList<VanBanChoChiDaoLV2>>> getAllVBDaChiDaoPhongChuaXuLyDonViCapHaiPhong(@Header("Authorization") String token,
                                                                                                      @Query("nam") String nam,
                                                                                                      @Query("page") int page,
                                                                                                      @Query("size") int size);

    @GET("api/VanBanDen/countAllVBDaChiDaoPhongChuaXuLyDonViCapHaiPhong")
    Observable<Response<Integer>> countAllVBDaChiDaoPhongChuaXuLyDonViCapHaiPhong(@Header("Authorization") String token,
                                                                                  @Query("nam") String nam);

    @POST("api/VanBanDen/duyetVBDaChiDaoPhongChuaXuLyDonViCapHaiPhong")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBDaChiDaoPhongChuaXuLyDonViCapHaiPhong(@Header("Authorization") String token,
                                                                               @Field("nam") String nam,
                                                                               @Field("id") int id,
                                                                               @Field("idLanhDao") int idLanhDao,
                                                                               @Field("tenLanhDao") String tenLanhDao,
                                                                               @Field("idPhongChuTri") int idPhongChuTri,
                                                                               @Field("tenPhongChuTri") String tenPhongChuTri,
                                                                               @Field("idPhongPhoiHops") String idPhongPhoiHops,
                                                                               @Field("tenPhongPhoiHops") String tenPhongPhoiHops,
                                                                               @Field("hanXuLy") String hanXuLy);

    //[TRUONG PHONG CHI CUC]   [QUAN LY DAU VIEC ] Đầu việc phòng chủ trì chờ xử lý
    @GET("api/DauViecNoBoSo/getAllDauViecPhongChuTriChoXuLyTPCC")
    Observable<Response<ArrayList<DauViecPhongChuTriChoXuLyTPCC>>> getAllDauViecPhongChuTriChoXuLyTPCC(@Header("Authorization") String token,
                                                                                                       @Query("nam") String nam);

    @POST("api/DauViecNoBoSo/duyetDauViecPhongChuTriChoXuLyTPCC")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetDauViecPhongChuTriChoXuLyTPCC(@Header("Authorization") String token,
                                                                     @Field("nam") String nam,
                                                                     @Field("id") int id,
                                                                     @Field("idPhoPhong") int idPhoPhong,
                                                                     @Field("tenPhoPhong") String tenPhoPhong,
                                                                     @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                                     @Field("tenPhoPhongPhoiHops") String tenPhoPhongPhoiHops,
                                                                     @Field("idChuyenVien") int idChuyenVien,
                                                                     @Field("tenChuyenVien") String tenChuyenVien,
                                                                     @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                     @Field("tenChuyenVienPhoiHops") String tenChuyenVienPhoiHops,
                                                                     @Field("hanXuLy") String hanXuLy);

    //[TRUONG PHONG CHI CUC] [QUAN LY DAU VIEC ] Đầu việc phòng phối hợp chờ xử lý
    @GET("api/DauViecNoBoSo/getAllDauViecPhongPhoHopChoXuLyTPCC")
    Observable<Response<ArrayList<DauViecPhongChuTriChoXuLyTPCC>>> getAllDauViecPhongPhoHopChoXuLyTPCC(@Header("Authorization") String token,
                                                                                                       @Query("nam") String nam);

    @POST("api/DauViecNoBoSo/duyetDauViecPhongPhoHopChoXuLyTPCC")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetDauViecPhongPhoHopChoXuLyTPCC(@Header("Authorization") String token,
                                                                     @Field("nam") String nam,
                                                                     @Field("id") int id,
                                                                     @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                                     @Field("tenPhoPhongPhoiHops") String tenPhoPhongPhoiHops,
                                                                     @Field("hanXuLy") String hanXuLy);

    //[TRUONG PHONG CHI CUC] [QUAN LY DAU VIEC ] Đầu việc phòng phối hợp chờ xử lý
    @GET("api/DauViecNoBoSo/getAllDauViecTruongPhongPhoHopCT")
    Observable<Response<ArrayList<DauViecPhongChuTriChoXuLyTPCC>>> getAllDauViecTruongPhongPhoHopCT(@Header("Authorization") String token,
                                                                                                    @Query("nam") String nam);

    @POST("api/DauViecNoBoSo/duyetDauViecTruongPhongPhoHopCT")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetDauViecTruongPhongPhoHopCT(@Header("Authorization") String token,
                                                                  @Field("nam") String nam,
                                                                  @Field("id") int id,
                                                                  @Field("idPhoPhong") int idPhoPhong,
                                                                  @Field("tenPhoPhong") String tenPhoPhong,
                                                                  @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                                  @Field("tenPhoPhongPhoiHops") String tenPhoPhongPhoiHops,
                                                                  @Field("idChuyenVien") int idChuyenVien,
                                                                  @Field("tenChuyenVien") String tenChuyenVien,
                                                                  @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                  @Field("tenChuyenVienPhoiHops") String tenChuyenVienPhoiHops,
                                                                  @Field("hanXuLy") String hanXuLy);

    //[TRUONG PHONG CHI CUC] [QUAN LY DAU VIEC ] DS phòng chủ trì đã chỉ đạo (Chưa hoàn thành)
    @GET("api/DauViecNoBoSo/getAllDauViecPhongChuTriDaXuLyTPCC")
    Observable<Response<ArrayList<DanhSachDauViecPhongChuTriDaChiDaoChuaHT>>> getAllDauViecPhongChuTriDaXuLyTPCC(@Header("Authorization") String token,
                                                                                                                 @Query("nam") String nam);

    //[TRUONG PHONG CHI CUC] [QUAN LY DAU VIEC ] DS phòng phối hợp đã chỉ đạo
    @GET("api/DauViecNoBoSo/getAllDauViecPhongPhoHopDaXuLyTPCC")
    Observable<Response<ArrayList<DanhSachPhongPhoiHopDaChiDaoTPCC>>> getAllDauViecPhongPhoHopDaXuLyTPCC(@Header("Authorization") String token,
                                                                                                         @Query("nam") String nam);

    //[TRUONG PHONG CHI CUC] [QUAN LY DAU VIEC ] DS đầu việc đã chỉ đạo trưởng phòng phối hợp
    @GET("api/DauViecNoBoSo/getAllDauViecDaChiDaoTruongPhongPhoHopCT")
    Observable<Response<ArrayList<DanhSachDauViecPhongChuTriDaChiDaoChuaHT>>> getAllDauViecDaChiDaoTruongPhongPhoHopCT(@Header("Authorization") String token,
                                                                                                                       @Query("nam") String nam);

    //
    @POST("api/XulyVanBan/traLaiDeXuatCVTPCC")
    @FormUrlEncoded
    Observable<Response<Boolean>> traLaiDeXuatCVTPCC(@Header("Authorization") String token,
                                                     @Field("nam") String nam,
                                                     @Field("idVB") int idVB,
                                                     @Field("IdPhongPhoiHop") int IdPhongPhoiHop,
                                                     @Field("yKien") String yKien,
                                                     @Field("urlFileYeuCau") String urlFileYeuCau);

    @POST("api/XulyVanBan/guiLenDeXuatCVTPCC")
    @FormUrlEncoded
    Observable<Response<Boolean>> guiLenDeXuatCVTPCC(@Header("Authorization") String token,
                                                     @Field("nam") String nam,
                                                     @Field("idVB") int idVB,
                                                     @Field("IdPhongPhoiHop") int IdPhongPhoiHop,
                                                     @Field("yKien") String yKien,
                                                     @Field("urlFileYeuCau") String urlFileYeuCau);

    //[TRUONG PHONG CHI CUC] [XỬ LÝ GIẤY MỜI] Giấy mời phối hợp đã xử lý:
    @GET("api/XuLyGiayMoi/getAllGMPhoiHopDaChiDaoCC")
    Observable<Response<ArrayList<GiayMoiPhoiHopDaXuLy>>> getAllGMPhoiHopDaChiDaoCC(@Header("Authorization") String token,
                                                                                    @Query("nam") String nam,
                                                                                    @Query("page") int page,
                                                                                    @Query("size") int size);

    @GET("api/XuLyGiayMoi/countAllGMPhoiHopDaChiDaoCC")
    Observable<Response<Integer>> countAllGMPhoiHopDaChiDaoCC(@Header("Authorization") String token,
                                                              @Query("nam") String nam);

    //[VAN BAN CAP HAI LEVE 3 ] Văn bản chờ xử lý (VB chủ trì)
    @GET("api/VanBanDen/getAllVBChoXuLyTPChuTriDonViCapHai")
    Observable<Response<ArrayList<VanBanChoXuLyLV3>>> getAllVBChoXuLyTPChuTriDonViCapHai(@Header("Authorization") String token,
                                                                                         @Query("nam") String nam,
                                                                                         @Query("page") int page,
                                                                                         @Query("size") int size);

    @GET("api/VanBanDen/countAllVBChoXuLyTPChuTriDonViCapHai")
    Observable<Response<Integer>> countAllVBChoXuLyTPChuTriDonViCapHai(@Header("Authorization") String token,
                                                                       @Query("nam") String nam);

    @POST("api/VanBanDen/duyetVBChoXuLyTPChuTriDonViCapHai")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBChoXuLyTPChuTriDonViCapHai(@Header("Authorization") String token,
                                                                    @Field("nam") String nam,
                                                                    @Field("id") int id,
                                                                    @Field("idPhoPhong") int idPhoPhong,
                                                                    @Field("chiDaoPhoPhong") String tenPhoPhong,
                                                                    @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                                    @Field("chiDaoPhoPhongPhoiHops") String chiDaoPhoPhongPhoiHops,
                                                                    @Field("idChuyenVien") int idChuyenVien,
                                                                    @Field("chiDaoChuyenVien") String chiDaoChuyenVien,
                                                                    @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                    @Field("chiDaoChuyenVienPhoiHops") String chiDaoChuyenVienPhoiHops,
                                                                    @Field("hanXuLy") String hanXuLy);

    //[VAN BAN CAP HAI LEVE 3 ] Văn bản chờ xử lý (VB phối hợp)
    @POST("api/VanBanDen/duyetVBChoXuLyTPPhoiHopDonViCapHai")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBChoXuLyTPPhoiHopDonViCapHai(@Header("Authorization") String token,
                                                                     @Field("nam") String nam,
                                                                     @Field("id") int id,
                                                                     @Field("idPhoPhong") int idPhoPhong,
                                                                     @Field("chiDaoPhoPhong") String tenPhoPhong,
                                                                     @Field("idPhoPhongPhoiHops") String idPhoPhongPhoiHops,
                                                                     @Field("chiDaoPhoPhongPhoiHops") String chiDaoPhoPhongPhoiHops,
                                                                     @Field("idChuyenVien") int idChuyenVien,
                                                                     @Field("chiDaoChuyenVien") String chiDaoChuyenVien,
                                                                     @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                     @Field("chiDaoChuyenVienPhoiHops") String chiDaoChuyenVienPhoiHops,
                                                                     @Field("hanXuLy") String hanXuLy);

    @GET("api/VanBanDen/getAllVBChoXuLyTPPhoiHopDonViCapHai")
    Observable<Response<ArrayList<VanBanChoXuLyLV3>>> getAllVBChoXuLyTPPhoiHopDonViCapHai(@Header("Authorization") String token,
                                                                                          @Query("nam") String nam,
                                                                                          @Query("page") int page,
                                                                                          @Query("size") int size);

    @GET("api/VanBanDen/countAllVBChoXuLyTPPhoiHopDonViCapHai")
    Observable<Response<Integer>> countAllVBChoXuLyTPPhoiHopDonViCapHai(@Header("Authorization") String token,
                                                                        @Query("nam") String nam);

    //[VAN BAN CAP HAI LEVE 3 ] Văn bản đã xử lý (VB chủ trì - Chưa kết thúc)
    @GET("api/VanBanDen/getAllVBDaXuLyTPChuTriDonViCapHai")
    Observable<Response<ArrayList<VanBanChoXuLyLV3>>> getAllVBDaXuLyTPChuTriDonViCapHai(@Header("Authorization") String token,
                                                                                        @Query("nam") String nam,
                                                                                        @Query("page") int page,
                                                                                        @Query("size") int size);

    @GET("api/VanBanDen/countAllVBDaXuLyTPChuTriDonViCapHai")
    Observable<Response<Integer>> countAllVBDaXuLyTPChuTriDonViCapHai(@Header("Authorization") String token,
                                                                      @Query("nam") String nam);

    //[VAN BAN CAP HAI LEVE 3 ] Văn bản đã xử lý (VB phối hợp - Chưa kết thúc)
    @GET("api/VanBanDen/getAllVBDaXuLyTPPhoHopDonViCapHai")
    Observable<Response<ArrayList<VanBanChoXuLyLV3>>> getAllVBDaXuLyTPPhoHopDonViCapHai(@Header("Authorization") String token,
                                                                                        @Query("nam") String nam,
                                                                                        @Query("page") int page,
                                                                                        @Query("size") int size);

    @GET("api/VanBanDen/countAllVBDaXuLyTPPhoHopDonViCapHai")
    Observable<Response<Integer>> countAllVBDaXuLyTPPhoHopDonViCapHai(@Header("Authorization") String token,
                                                                      @Query("nam") String nam);

    //[VAN BAN CAP HAI LEVE 3 ]  Văn bản chờ duyệt
    @GET("api/VanBanDen/getAllVBChoDuyetTPDonViCapHai")
    Observable<Response<ArrayList<VanBanChoDuyetLV3>>> getAllVBChoDuyetTPDonViCapHai(@Header("Authorization") String token,
                                                                                     @Query("nam") String nam,
                                                                                     @Query("page") int page,
                                                                                     @Query("size") int size);

    @GET("api/VanBanDen/countAllVBChoDuyetTPDonViCapHai")
    Observable<Response<Integer>> countAllVBChoDuyetTPDonViCapHai(@Header("Authorization") String token,
                                                                  @Query("nam") String nam);

    @POST("api/VanBanDen/duyetVBChoDuyetTPDonViCapHai")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBChoDuyetTPDonViCapHai(@Header("Authorization") String token,
                                                               @Field("nam") String nam,
                                                               @Field("id") int id);

    //[VAN BAN CAP HAI LEVE 3 ] Danh sách văn bản phòng chủ trì -  Danh sách văn bản phòng phối hợp
    @GET("api/VanBanDen/getAllVBDonViCapHai")
    Observable<Response<ArrayList<DanhSachvanBanPhongChuTriLV3>>> getAllVBDonViCapHai(@Header("Authorization") String token,
                                                                                      @Query("nam") String nam,
                                                                                      @Query("type") int type,
                                                                                      @Query("page") int page,
                                                                                      @Query("size") int size);

    @GET("api/VanBanDen/countAllVBDonViCapHai")
    Observable<Response<Integer>> countAllVBDonViCapHai(@Header("Authorization") String token,
                                                        @Query("nam") String nam,
                                                        @Query("type") int type);

    @POST("api/XulyVanBan/traLaiDeXuatPhoiHopTPCC")
    @FormUrlEncoded
    Observable<Response<Boolean>> traLaiDeXuatPhoiHopTPCC(@Header("Authorization") String token,
                                                          @Field("nam") String nam,
                                                          @Field("idVB") int idVB,
                                                          @Field("IdPhongPhoiHop") int IdPhongPhoiHop,
                                                          @Field("yKien") String yKien,
                                                          @Field("urlFileYeuCau") String urlFileYeuCau);

    //[VAN BAN CAP HAI LEVE 4 ] Văn bản chờ xử lý (VB chủ trì)
    @GET("api/VanBanDen/getAllVBChoXuLyPPChuTriDonViCapHai")
    Observable<Response<ArrayList<VanBanChoXuLyVBChuTriLV4>>> getAllVBChoXuLyPPChuTriDonViCapHai(@Header("Authorization") String token,
                                                                                                 @Query("nam") String nam,
                                                                                                 @Query("page") int page,
                                                                                                 @Query("size") int size);

    @GET("api/VanBanDen/countAllVBChoXuLyPPChuTriDonViCapHai")
    Observable<Response<Integer>> countAllVBChoXuLyPPChuTriDonViCapHai(@Header("Authorization") String token,
                                                                       @Query("nam") String nam);

    @POST("api/VanBanDen/duyetVBChoXuLyPPChuTriDonViCapHai")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBChoXuLyPPChuTriDonViCapHai(@Header("Authorization") String token,
                                                                    @Field("nam") String nam,
                                                                    @Field("id") int id,
                                                                    @Field("idChuyenVien") int idChuyenVien,
                                                                    @Field("chiDaoChuyenVien") String chiDaoChuyenVien,
                                                                    @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                    @Field("chiDaoChuyenVienPhoiHops") String chiDaoChuyenVienPhoiHops,
                                                                    @Field("hanXuLy") String hanXuLy);

    //[VAN BAN CAP HAI LEVE 4 ] Văn bản chờ xử lý (VB phối hợp)
    @GET("api/VanBanDen/getAllVBChoXuLyPPPhoiHopDonViCapHai")
    Observable<Response<ArrayList<VanBanChoXuLyVBChuTriLV4>>> getAllVBChoXuLyPPPhoiHopDonViCapHai(@Header("Authorization") String token,
                                                                                                  @Query("nam") String nam,
                                                                                                  @Query("page") int page,
                                                                                                  @Query("size") int size);

    @GET("api/VanBanDen/countAllVBChoXuLyPPPhoiHopDonViCapHai")
    Observable<Response<Integer>> countAllVBChoXuLyPPPhoiHopDonViCapHai(@Header("Authorization") String token,
                                                                        @Query("nam") String nam);

    @POST("api/VanBanDen/duyetVBChoXuLyPPhoiHopDonViCapHai")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBChoXuLyPPhoiHopDonViCapHai(@Header("Authorization") String token,
                                                                    @Field("nam") String nam,
                                                                    @Field("id") int id,
                                                                    @Field("idChuyenVien") int idChuyenVien,
                                                                    @Field("chiDaoChuyenVien") String chiDaoChuyenVien,
                                                                    @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                    @Field("chiDaoChuyenVienPhoiHops") String chiDaoChuyenVienPhoiHops,
                                                                    @Field("hanXuLy") String hanXuLy);

    //[VAN BAN CAP HAI LEVE 4 ] Văn bản phối hợp chờ xử lý
    @GET("api/VanBanDen/getAllVBPhoiHopChoXuLyDonViCapHai")
    Observable<Response<ArrayList<VanBanPhoiHopChoXuLyLV4>>> getAllVBPhoiHopChoXuLyDonViCapHai(@Header("Authorization") String token,
                                                                                               @Query("nam") String nam,
                                                                                               @Query("page") int page,
                                                                                               @Query("size") int size);

    @GET("api/VanBanDen/countAllVBPhoiHopChoXuLyDonViCapHai")
    Observable<Response<Integer>> countAllVBPhoiHopChoXuLyDonViCapHai(@Header("Authorization") String token,
                                                                      @Query("nam") String nam);

    @POST("api/VanBanDen/duyetVBPhoiHopChoXuLyDonViCapHai")
    @FormUrlEncoded
    Observable<Response<Boolean>> duyetVBPhoiHopChoXuLyDonViCapHai(@Header("Authorization") String token,
                                                                   @Field("nam") String nam,
                                                                   @Field("id") int id,
                                                                   @Field("CT_PH") int CT_PH,
                                                                   @Field("idChuyenVienPhoiHops") String idChuyenVienPhoiHops,
                                                                   @Field("chiDaoChuyenVienPhoiHops") String chiDaoChuyenVienPhoiHops,
                                                                   @Field("hanXuLy") String hanXuLy);

    //[VAN BAN CAP HAI LEVE 4 ] Văn bản đã xử lý (VB chủ trì - Chưa kết thúc)
    @GET("api/VanBanDen/getAllVBDaXuLyPPChuTriDonViCapHai")
    Observable<Response<ArrayList<VanBanChoXuLyVBChuTriLV4>>> getAllVBDaXuLyPPChuTriDonViCapHai(@Header("Authorization") String token,
                                                                                                @Query("nam") String nam,
                                                                                                @Query("page") int page,
                                                                                                @Query("size") int size);

    @GET("api/VanBanDen/countAllVBDaXuLyPPChuTriDonViCapHai")
    Observable<Response<Integer>> countAllVBDaXuLyPPChuTriDonViCapHai(@Header("Authorization") String token,
                                                                      @Query("nam") String nam);

    //[VAN BAN CAP HAI LEVE 4 ] Văn bản đã xử lý (VB phối hợp - Chưa kết thúc)
    @GET("api/VanBanDen/getAllVBDaXuLyPPPhoiHopDonViCapHai")
    Observable<Response<ArrayList<VanBanChoXuLyVBChuTriLV4>>> getAllVBDaXuLyPPPhoiHopDonViCapHai(@Header("Authorization") String token,
                                                                                                 @Query("nam") String nam,
                                                                                                 @Query("page") int page,
                                                                                                 @Query("size") int size);

    @GET("api/VanBanDen/countAllVBDaXuLyPPPhoiHopDonViCapHai")
    Observable<Response<Integer>> countAllVBDaXuLyPPPhoiHopDonViCapHai(@Header("Authorization") String token,
                                                                       @Query("nam") String nam);

    //[VAN BAN CAP HAI LEVE 4 ] Văn bản phối hợp đã xử lý
    @GET("api/VanBanDen/getAllVBPhoiHopDaXuLyDonViCapHai")
    Observable<Response<ArrayList<VanBanPhoiHopChoXuLyLV4>>> getAllVBPhoiHopDaXuLyDonViCapHai(@Header("Authorization") String token,
                                                                                              @Query("nam") String nam,
                                                                                              @Query("page") int page,
                                                                                              @Query("size") int size);

    @GET("api/VanBanDen/countAllVBPhoiHopDaXuLyDonViCapHai")
    Observable<Response<Integer>> countAllVBPhoiHopDaXuLyDonViCapHai(@Header("Authorization") String token,
                                                                     @Query("nam") String nam);

    //[VAN BAN CAP HAI LEVE 5 ] Văn bản chờ xử lý (VB chủ trì)
    @GET("api/VanBanDen/getAllVBChoXuLyCVChuTriDonViCapHai")
    Observable<Response<ArrayList<VanBanChoXuLyLV5>>> getAllVBChoXuLyCVChuTriDonViCapHai(@Header("Authorization") String token,
                                                                                         @Query("nam") String nam,
                                                                                         @Query("page") int page,
                                                                                         @Query("size") int size);

    @GET("api/VanBanDen/countAllVBChoXuLyCVChuTriDonViCapHai")
    Observable<Response<Integer>> countAllVBChoXuLyCVChuTriDonViCapHai(@Header("Authorization") String token,
                                                                       @Query("nam") String nam);

    //[VAN BAN CAP HAI LEVE 5 ] Văn bản chờ xử lý (VB phối hợp)
    @GET("api/VanBanDen/getAllVBChoXuLyCVPhoiHopDonViCapHai")
    Observable<Response<ArrayList<VanBanChoXuLyLV5>>> getAllVBChoXuLyCVPhoiHopDonViCapHai(@Header("Authorization") String token,
                                                                                          @Query("nam") String nam,
                                                                                          @Query("page") int page,
                                                                                          @Query("size") int size);

    @GET("api/VanBanDen/countAllVBChoXuLyCVPhoiHopDonViCapHai")
    Observable<Response<Integer>> countAllVBChoXuLyCVPhoiHopDonViCapHai(@Header("Authorization") String token,
                                                                        @Query("nam") String nam);

    //[VAN BAN CAP HAI LEVE 5 ] Văn bản phối hợp chờ xử lý
    @GET("api/VanBanDen/getAllVBPhoiHopChoXuLyCVDonViCapHai")
    Observable<Response<ArrayList<VanBanChoXuLyLV5>>> getAllVBPhoiHopChoXuLyCVDonViCapHai(@Header("Authorization") String token,
                                                                                          @Query("nam") String nam,
                                                                                          @Query("page") int page,
                                                                                          @Query("size") int size);

    @GET("api/VanBanDen/countAllVBPhoiHopChoXuLyCVDonViCapHai")
    Observable<Response<Integer>> countAllVBPhoiHopChoXuLyCVDonViCapHai(@Header("Authorization") String token,
                                                                        @Query("nam") String nam);

    //[VAN BAN CAP HAI LEVE 5 ] Văn bản đã xử lý (VB chủ trì)
    @GET("api/VanBanDen/getAllVBDaXuLyCVChuTriDonViCapHai")
    Observable<Response<ArrayList<VanBanChoXuLyLV5>>> getAllVBDaXuLyCVChuTriDonViCapHai(@Header("Authorization") String token,
                                                                                        @Query("nam") String nam,
                                                                                        @Query("page") int page,
                                                                                        @Query("size") int size);

    @GET("api/VanBanDen/countAllVBDaXuLyCVChuTriDonViCapHai")
    Observable<Response<Integer>> countAllVBDaXuLyCVChuTriDonViCapHai(@Header("Authorization") String token,
                                                                      @Query("nam") String nam);

    //[VAN BAN CAP HAI LEVE 5 ] Văn bản đã xử lý (VB phối hợp)
    @GET("api/VanBanDen/getAllVBDaXuLyCVPhoiHopDonViCapHai")
    Observable<Response<ArrayList<VanBanChoXuLyLV5>>> getAllVBDaXuLyCVPhoiHopDonViCapHai(@Header("Authorization") String token,
                                                                                         @Query("nam") String nam,
                                                                                         @Query("page") int page,
                                                                                         @Query("size") int size);

    @GET("api/VanBanDen/countAllVBDaXuLyCVPhoiHopDonViCapHai")
    Observable<Response<Integer>> countAllVBDaXuLyCVPhoiHopDonViCapHai(@Header("Authorization") String token,
                                                                       @Query("nam") String nam);

    //[VAN BAN CAP HAI LEVE 5 ] Văn bản phối hợp đã xử lý
    @GET("api/VanBanDen/getAllVBPhoiHopDaXuLyCVDonViCapHai")
    Observable<Response<ArrayList<VanBanChoXuLyLV5>>> getAllVBPhoiHopDaXuLyCVDonViCapHai(@Header("Authorization") String token,
                                                                                         @Query("nam") String nam,
                                                                                         @Query("page") int page,
                                                                                         @Query("size") int size);

    @GET("api/VanBanDen/countAllVBPhoiHopDaXuLyCVDonViCapHai")
    Observable<Response<Integer>> countAllVBPhoiHopDaXuLyCVDonViCapHai(@Header("Authorization") String token,
                                                                       @Query("nam") String nam);

    @GET("api/VanBanDen/getDetailVanBanChoXuLyGQ")
    Observable<Response<DetailVanBanChoXuLyGQ>> getDetailVanBanChoXuLyGQ(@Header("Authorization") String token,
                                                                         @Query("nam") String nam,
                                                                         @Query("id") int id);

    @POST("api/VanBanDen/hoanThanhVBChoXuLyGQ")
    @FormUrlEncoded
    Observable<Response<Boolean>> hoanThanhVBChoXuLyGQ(@Header("Authorization") String token,
                                                       @Field("id") int id,
                                                       @Field("nam") String nam,
                                                       @Field("noiDung") String noiDung);

    @POST("api/VanBanDen/chamMuonVBChoXuLyGQ")
    @FormUrlEncoded
    Observable<Response<Boolean>> chamMuonVBChoXuLyGQ(@Header("Authorization") String token,
                                                      @Field("id") int id,
                                                      @Field("nam") String nam,
                                                      @Field("noiDung") String noiDung);

    //Doi mat khau
    @POST("api/Account/doiMatKhau")
    @FormUrlEncoded
    Observable<Response<Boolean>> doiMatKhau(@Header("Authorization") String token,
                                             @Field("nam") String nam,
                                             @Field("currenPassword") String currenPassword,
                                             @Field("newPassword") String newPassword);

    //Thong Bao Main
    @GET("api/DanhMuc/getThongBaoHome")
    Observable<Response<String>> getThongBaoHome(@Header("Authorization") String token,
                                                 @Query("nam") String nam);
}
