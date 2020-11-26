package com.example.dietapp.DietFood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.dietapp.R;

import java.util.ArrayList;
import java.util.List;

public class Diet_list extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Diet> dietList = new ArrayList<>();
    private DietAdapter dAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diet_list);
        recyclerView = findViewById(R.id.recycler_view);
        dAdapter = new DietAdapter(dietList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(dAdapter);
        prepareDietFood();
    }

    private void prepareDietFood(){
        Diet diet = new Diet(R.drawable.dfood1,"검은콩","검은콩 1컵 분량에는 15g의 단백질을 함유하고 있는데, 붉은 고기 등 다른 단백질 공급원에서 발견된느 포화 지방이 들어있지 않습니다."
                ,1);
        dietList.add(diet);

        diet = new Diet(R.drawable.dfood2,"귀리","귀리는 섬유질이 풍부해서 하루 종일 기분 전환에 도움을 줍니다. 귀리 반컵에는 신진대사를 촉진시키고 지방을 태우는 건강한 탄수화물인 살 빠지는 저항성 전분 4.6g이 들어 있습니다.",2);
        dietList.add(diet);

        diet = new Diet(R.drawable.dfood3,"아보카도","아보카도의 건강한 단일 불포화지방의 화합물인 올레산은 배고픔을 잊게 해주고 포만감을 가득 채워준다. 섬유질과 단백질 성분도 가득 함유되어 있다.",
                3);
        dietList.add(diet);

        diet = new Diet(R.drawable.dfood4,"블루베리","안티 에이징 효과가 높다고 알려진 블루 베리는 작지만 강력한 영양을 가진음식입니다. 1컵 분량을 섭취하면 80kcal 밖에 안되지만 4g의 섬유질로 가득차 있습니다.",4);
        dietList.add(diet);

        diet = new Diet(R.drawable.dfood5,"브로콜리","요리되거나 날 것으로 먹는 십자화과 야채에 속하는 브로콜리는 암 예방 능력이 뛰어난 것으로 잘 알려져 잇지만, 30kcal 미만의 음식으로 섬유소를 채워주며 체중감소에도 도움이 된다.",5);
        dietList.add(diet);

        diet = new Diet(R.drawable.dfood6,"현미","현미 반컵에는 1.7g의 저항성 전분을 함유하고 있다. 이 전분은 신진  대사를 촉진시키고 지방을 태우는 건강한 탄수화물이다.",6);
        dietList.add(diet);

        diet = new Diet(R.drawable.dfood7,"배","섬유질이 풍부하며 껍질에는 생리활성물질과 다량의 섬유질이 함유돼 있어, 체내 노폐물이나 독성물질을 배설시켜준다.",7);
        dietList.add(diet);

        diet = new Diet(R.drawable.dfood8,"자몽","식사 전에 자몽 반을 먹으면 일주이에 0.45kg까지 빠질수 있다. 열매의 화합물은 지방 축적 호르몬인 인슐린을 낮춰준다.",8);
        dietList.add(diet);

        diet = new Diet(R.drawable.dfood9,"바나나","신진대사를 촉신시켜주고 잘 익은 바나나조차도 5g정도의 내성전분을 가지고 있다.",9);
        dietList.add(diet);


    }
}