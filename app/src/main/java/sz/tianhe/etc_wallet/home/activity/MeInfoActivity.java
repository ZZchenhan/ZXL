package sz.tianhe.etc_wallet.home.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.presenter.IBasePresenter;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.baselib.weight.ActionSheetDialog;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityMeInfoBinding;
import sz.tianhe.etc_wallet.home.presenter.UpdatePresenter;
import sz.tianhe.etc_wallet.utils.StatusBarUtils;

public class MeInfoActivity extends BaseActivity implements View.OnClickListener, UpdatePresenter.OnUpdateViewSuccss {

    ActivityMeInfoBinding binding;
    boolean isEdit = false;

    @Override
    public int layoutId() {
        return R.layout.activity_me_info;
    }

    @Override
    public IBaseNavagation navagation() {

        return null;
    }


    @Override
    public void initView() {
        StatusBarUtils.hideStatus(this);
        binding.tvUpdateHead.setText("");
        binding.tvUpdateHead.setOnClickListener(this);
        binding.toolbar.setNavigationOnClickListener(v -> finish());
        binding.right.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if (!isEdit) {
                    ((TextView) v).setText("提交");
                    binding.tvUpdateHead.setText("更换头像");
                    binding.etName.setEnabled(true);
                    binding.etSex.setOnClickListener(MeInfoActivity.this);
                    isEdit = true;
                    return;
                } else {
//                    updatePresenter.updateUserInfo(upload,binding.etName.getText().toString(),binding.etSex.getText().toString());
                    toast("修改用户信息");
                }
            }
        });
        setUserInfo();
    }

    @Override
    public void findViews() {

    }

    @Override
    protected View bindViews() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_me_info, null, false);
        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_update_head:
                choosePic();
                break;
            case R.id.et_sex:
                chooseSex();
                break;
        }
    }

    private void chooseSex() {
        ActionSheetDialog dialog = new ActionSheetDialog(this).builder()
                .addSheetItem("男", ActionSheetDialog.SheetItemColor.Blue, which -> binding.etSex.setText("男"))
                .addSheetItem("女", ActionSheetDialog.SheetItemColor.Blue, which -> binding.etSex.setText("女"))
                .setCancelable(true);
        dialog.show();
    }

    private void choosePic() {
        ActionSheetDialog dialog = new ActionSheetDialog(this).builder()
                .addSheetItem("相册", ActionSheetDialog.SheetItemColor.Blue, which -> PictureSelector.create(MeInfoActivity.this)
                        .openGallery(PictureMimeType.ofImage())
                        .maxSelectNum(1)
                        .enableCrop(true)
                        .withAspectRatio(1, 1)
                        .isCamera(false)
                        .forResult(PictureConfig.CHOOSE_REQUEST))
                .addSheetItem("拍照", ActionSheetDialog.SheetItemColor.Blue, which -> PictureSelector.create(MeInfoActivity.this)
                        .openCamera(PictureMimeType.ofImage())
                        .enableCrop(true)
                        .withAspectRatio(1, 1)
                        .forResult(PictureConfig.CHOOSE_REQUEST))
                .setCancelable(true);
        dialog.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == PictureConfig.CHOOSE_REQUEST) {
                String headImgPath;
                // 图片选择结果回调
                List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                // 例如 LocalMedia 里面返回三种path
                // 1.media.getPath(); 为原图path
                // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                LocalMedia media = selectList.get(0);
                if (media.isCut()) {
                    headImgPath = media.getCutPath();
                } else {
                    headImgPath = media.getPath();
                }
                Glide.with(MeInfoActivity.this)
                        .load(headImgPath)
                        .into(binding.imageView2);

            }
        }
    }

    private void setUserInfo(){

    }


    private String upload = null;
    @Override
    public void onUploadSuccss(String url) {
        upload = url;
    }

    @Override
    public void updateUserInfoSuccss() {
        finish();
    }
}
