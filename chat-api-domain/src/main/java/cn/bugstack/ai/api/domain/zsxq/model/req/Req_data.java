package cn.bugstack.ai.api.domain.zsxq.model.req;

/**
 * @Author 彬哥，邮箱：13450770408@163.com
 * @Description
 * @Date 2023/5/23 16:03
 * github:https://github.com/china-sebastian
 */
public class Req_data {

    private String text;
    private String[] image_ids = new String[]{};
    private boolean silenced;

    public Req_data(String text, boolean silenced) {
        this.text = text;
        this.silenced = silenced;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getImage_ids() {
        return image_ids;
    }

    public void setImage_ids(String[] image_ids) {
        this.image_ids = image_ids;
    }

    public boolean isSilenced() {
        return silenced;
    }

    public void setSilenced(boolean silenced) {
        this.silenced = silenced;
    }
}

