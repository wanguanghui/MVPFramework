package com.wgh.mvpframework.common.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;

import java.io.File;

public class WccGlide {

    private WccGlide() {

    }

    /**
     * 加载图片（最基本用法）
     *
     * @param context 上下文对象
     * @param imgUrl  图片url
     * @param target  要显示图片的ImageView
     */
    public static void loadImage(Context context, String imgUrl, ImageView target) {
        Glide.with(context).load(processImgUrl(imgUrl)).into(target);
    }

    /**
     * 加载图片，有淡入淡出动画效果（推荐使用）
     *
     * @param context 上下文对象
     * @param imgUrl  图片url
     * @param target  要显示图片的ImageView
     */
    public static void loadImageWithCrossFade(Context context, String imgUrl, ImageView target) {
        Glide.with(context).load(processImgUrl(imgUrl))
                .crossFade()
                .into(target);
    }

    /**
     * 加载图片，可设置是否显示图片加载动画
     *
     * @param context       上下文对象
     * @param imgUrl        图片url
     * @param target        要显示图片的ImageView
     * @param needAnimation 图片显示时是否需要动画
     */
    public static void loadImage(Context context, String imgUrl, ImageView target, boolean needAnimation) {
        if (needAnimation) {
            loadImageWithCrossFade(context, imgUrl, target);
        } else {
            loadImage(context, imgUrl, target);
        }
    }

    /**
     * 加载图片，可设置占位符图片（注：使用自定义圆形ImageView控件时，needAnimation要设为false）
     *
     * @param context             上下文对象
     * @param imgUrl              图片url
     * @param target              要显示图片的ImageView
     * @param needAnimation       图片显示时是否需要动画
     * @param placeHolderImgResId 默认占位符图片的资源id，如不需要请传-1或者使用其他方法
     */
    public static void loadImageWithPlaceHolder(Context context, String imgUrl, ImageView target, boolean needAnimation, int placeHolderImgResId) {
        if (placeHolderImgResId >= 0) {
            if (needAnimation) {
                Glide.with(context).load(processImgUrl(imgUrl))
                        .placeholder(placeHolderImgResId)
                        .crossFade()
                        .into(target);
            } else {
                Glide.with(context).load(processImgUrl(imgUrl))
                        .dontAnimate()
                        .placeholder(placeHolderImgResId)
                        .into(target);
            }
        } else {
            loadImage(context, imgUrl, target, needAnimation);
        }
    }

    /**
     * 加载图片，可设置缺省图片
     *
     * @param context         上下文对象
     * @param imgUrl          图片url
     * @param target          要显示图片的ImageView
     * @param needAnimation   图片显示时是否需要动画
     * @param defaultImgResId 默认加载失败的显示图片，如不需要请传-1或者使用其他方法
     */
    public static void loadImageWithDefaultImage(Context context, String imgUrl, ImageView target, boolean needAnimation, int defaultImgResId) {
        if (defaultImgResId >= 0) {
            if (needAnimation) {
                Glide.with(context).load(processImgUrl(imgUrl))
                        .error(defaultImgResId)
                        .crossFade()
                        .into(target);
            } else {
                Glide.with(context).load(processImgUrl(imgUrl))
                        .error(defaultImgResId)
                        .into(target);
            }
        } else {
            loadImage(context, imgUrl, target, needAnimation);
        }
    }

    /**
     * 加载图片，可同时设置占位符和缺省图片（注：使用自定义圆形ImageView控件时，needAnimation要设为false）
     *
     * @param context             上下文对象
     * @param imgUrl              图片url
     * @param target              要显示图片的ImageView
     * @param needAnimation       图片显示时是否需要动画
     * @param placeHolderImgResId 默认占位符图片的资源id，如不需要请传-1或者使用其他方法
     * @param defaultImgResId     默认加载失败的显示图片，如不需要请传-1或者使用其他方法
     */
    public static void loadImage(Context context, String imgUrl, final ImageView target, boolean needAnimation, int placeHolderImgResId, int defaultImgResId) {
        if (placeHolderImgResId >= 0) {
            if (defaultImgResId >= 0) {
                /**
                 * 需要占位符图片，也需要缺省图片
                 */
                if (needAnimation) {
                    /**
                     * 需要显示动画
                     */
                    Glide.with(context).load(processImgUrl(imgUrl))
                            .placeholder(placeHolderImgResId)
                            .error(defaultImgResId)
                            .crossFade()
                            .into(target);
                } else {
                    /**
                     * 不需要显示动画
                     */
                    Glide.with(context).load(processImgUrl(imgUrl))
                            .dontAnimate()
                            .placeholder(placeHolderImgResId)
                            .error(defaultImgResId)
                            .into(target);
//                            .into(new SimpleTarget<GlideDrawable>() {
//                                @Override
//                                public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
//                                    target.setImageDrawable(resource);
//                                }
//
//                                @Override
//                                public void onLoadFailed(Exception e, Drawable errorDrawable) {
//                                    super.onLoadFailed(e, errorDrawable);
//                                    WccLogger.e("abc" , "onLoadFailed   " + e.getMessage());
//                                }
//                            });
                }
            } else {
                /**
                 * 需要占位符图片，不需要缺省图片
                 */
                loadImageWithPlaceHolder(context, imgUrl, target, needAnimation, placeHolderImgResId);
            }
        } else {
            if (defaultImgResId >= 0) {
                /**
                 * 不需要占位符图片，需要缺省图片
                 */
                loadImageWithDefaultImage(context, imgUrl, target, needAnimation, defaultImgResId);
            } else {
                /**
                 * 不需要占位符图片，也不需要缺省图片
                 */
                loadImage(context, imgUrl, target, needAnimation);
            }
        }
    }

    /**
     * 图片url处理，一般情况下均为包含http(s)的完整url
     *
     * @param inputUrl
     * @return
     */
    public static String processImgUrl(String inputUrl) {
        String host;
        if (inputUrl.startsWith("file://")) {
            host = "";
        } else if (inputUrl.startsWith("http://") || inputUrl.startsWith("https://")) {
            host = "";
        } else if (inputUrl.startsWith("img.wochacha.com/")
                || inputUrl.startsWith("imgalpha.wochacha.com/")) {
            host = "http://";
        } else {
            // 其他情况视为无效，保持原状态
            host = "";
        }

        return host + inputUrl;
    }

    /**
     * 清除磁盘缓存，异步操作
     *
     * @param context 上下文对象
     */
    public static void clearDiskCache(final Context context) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Glide.get(context).clearDiskCache();
            }
        }).start();
    }

    /**
     * 清除内存缓存，必须在主线程执行
     *
     * @param context 上下文对象
     */
    public static void clearMemoryAsPossible(Context context) {
        Glide.get(context).clearMemory();
    }

    /**
     * 清除图片所有缓存
     */
    public static void clearImageAllCache(Context context) {
        clearDiskCache(context);
        clearMemoryAsPossible(context);
        String ImageExternalCatchDir=context.getExternalCacheDir()+ ExternalCacheDiskCacheFactory.DEFAULT_DISK_CACHE_DIR;
        deleteFolderFile(ImageExternalCatchDir, true);
    }

    private static void deleteFolderFile(String filePath, boolean deleteThisPath) {
        if (!TextUtils.isEmpty(filePath)) {
            try {
                File file = new File(filePath);
                if (file.isDirectory()) {
                    File files[] = file.listFiles();
                    for (File file1 : files) {
                        deleteFolderFile(file1.getAbsolutePath(), true);
                    }
                }
                if (deleteThisPath) {
                    if (!file.isDirectory()) {
                        file.delete();
                    } else {
                        if (file.listFiles().length == 0) {
                            file.delete();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
