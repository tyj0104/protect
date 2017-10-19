package com.example.jay.myapplication.ui.agreement;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jay.myapplication.R;

/**
 * Created by Administrator on 2017/10/18
 */

public class AgreementActivity extends Activity implements View.OnClickListener {
    String s = "用户使用协议 " +
            "一、坚持党对一切工作的领导。必须增强政治意识、大局意识、核心意识、看齐意识，自觉维护党中央权威和集中统一领导，自觉在思想上政治上行动上同党中央保持高度一致，完善坚持党的领导的体制机制，坚持稳中求进工作总基调，统筹推进“五位一体”总体布局，协调推进“四个全面”战略布局，提高党把方向、谋大局、定政策、促改革的能力和定力，确保党始终总揽全局、协调各方。\n" +
            "二、坚持以人民为中心。必须坚持人民主体地位，坚持立党为公、执政为民，践行全心全意为人民服务的根本宗旨，把党的群众路线贯彻到治国理政全部活动之中，把人民对美好生活的向往作为奋斗目标，依靠人民创造历史伟业。\n" +
            "三、坚持全面深化改革。必须坚持和完善中国特色社会主义制度，不断推进国家治理体系和治理能力现代化，坚决破除一切不合时宜的思想观念和体制机制弊端，突破利益固化的藩篱，吸收人类文明有益成果，构建系统完备、科学规范、运行有效的制度体系，充分发挥我国社会主义制度优越性。\n" +
            "四、坚持新发展理念。发展是解决我国一切问题的基础和关键，发展必须是科学发展，必须坚定不移贯彻创新、协调、绿色、开放、共享的发展理念。\n" +
            "五、坚持人民当家作主。必须坚持中国特色社会主义政治发展道路，坚持和完善人民代表大会制度、中国共产党领导的多党合作和政治协商制度、民族区域自治制度、基层群众自治制度，巩固和发展最广泛的爱国统一战线，发展社会主义协商民主，健全民主制度，丰富民主形式，拓宽民主渠道，保证人民当家作主落实到国家政治生活和社会生活之中。\n" +
            "六、坚持全面依法治国。必须把党的领导贯彻落实到依法治国全过程和各方面，坚定不移走中国特色社会主义法治道路，完善以宪法为核心的中国特色社会主义法律体系，建设中国特色社会主义法治体系，建设社会主义法治国家，发展中国特色社会主义法治理论，坚持依法治国、依法执政、依法行政共同推进，坚持法治国家、法治政府、法治社会一体建设，坚持依法治国和以德治国相结合，依法治国和依规治党有机统一，深化司法体制改革，提高全民族法治素养和道德素质。\n" +
            "七、坚持社会主义核心价值体系。必须坚持马克思主义，牢固树立共产主义远大理想和中国特色社会主义共同理想，培育和践行社会主义核心价值观，不断增强意识形态领域主导权和话语权，推动中华优秀传统文化创造性转化、创新性发展，继承革命文化，发展社会主义先进文化，不忘本来、吸收外来、面向未来，更好构筑中国精神、中国价值、中国力量，为人民提供精神指引。\n" +
            "八、坚持在发展中保障和改善民生。必须多谋民生之利、多解民生之忧，在发展中补齐民生短板、促进社会公平正义，在幼有所育、学有所教、劳有所得、病有所医、老有所养、住有所居、弱有所扶上不断取得新进展，深入开展脱贫攻坚，保证全体人民在共建共享发展中有更多获得感，不断促进人的全面发展、全体人民共同富裕。\n" +
            "九、坚持人与自然和谐共生。必须树立和践行绿水青山就是金山银山的理念，坚持节约资源和保护环境的基本国策，像对待生命一样对待生态环境，统筹山水林田湖草系统治理，实行最严格的生态环境保护制度，形成绿色发展方式和生活方式，坚定走生产发展、生活富裕、生态良好的文明发展道路，建设美丽中国，为人民创造良好生产生活环境，为全球生态安全作出贡献。\n" +
            "十、坚持总体国家安全观。必须坚持国家利益至上，以人民安全为宗旨，以政治安全为根本，统筹外部安全和内部安全、国土安全和国民安全、传统安全和非传统安全、自身安全和共同安全，完善国家安全制度体系，加强国家安全能力建设，坚决维护国家主权、安全、发展利益。\n" +
            "十一、坚持党对人民军队的绝对领导。必须全面贯彻党领导人民军队的一系列根本原则和制度，确立新时代党的强军思想在国防和军队建设中的指导地位，坚持政治建军、改革强军、科技兴军、依法治军，更加注重聚焦实战，更加注重创新驱动，更加注重体系建设，更加注重集约高效，更加注重军民融合，实现党在新时代的强军目标。\n" +
            "十二、坚持“一国两制”和推进祖国统一。必须把维护中央对香港、澳门特别行政区全面管治权和保障特别行政区高度自治权有机结合起来，确保“一国两制”方针不会变、不动摇，确保“一国两制”实践不变形、不走样。必须坚持一个中国原则，坚持“九二共识”，推动两岸关系和平发展，深化两岸经济合作和文化往来，推动两岸同胞共同反对一切分裂国家的活动，共同为实现中华民族伟大复兴而奋斗。";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);
        initView();
    }


    private void initView() {
        TextView okTv = (TextView) findViewById(R.id.activity_agreement_ok_tv);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.activity_agreement_rl);
        okTv.setOnClickListener(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new Adapter());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_agreement_ok_tv:
                finish();
                break;
        }
    }

    class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

        @Override
        public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_agreement, null, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
            holder.content.setText(s);
        }

        @Override
        public int getItemCount() {
            return 1;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView content;

            ViewHolder(View itemView) {
                super(itemView);
                content = (TextView) itemView.findViewById(R.id.item_agreement_content);
            }
        }
    }
}