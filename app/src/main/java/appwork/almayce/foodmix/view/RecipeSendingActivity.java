package appwork.almayce.foodmix.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import appwork.almayce.foodmix.R;
import appwork.almayce.foodmix.databinding.ActivityRecipeBinding;

/**
 * Created by almayce on 24.07.17.
 */

public class RecipeSendingActivity extends AppCompatActivity {

    private ActivityRecipeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recipe);
        binding.btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.etRecipe.getText().toString().toCharArray().length > 3)
                    send();
                else
                    Toast.makeText(getApplicationContext(), "Заполните поля", Toast.LENGTH_SHORT).show();
            }
        });
    }

        private void send () {
            String to = "foodmixapp@gmail.com";

            Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
            email.putExtra(Intent.EXTRA_SUBJECT, binding.spKind.getSelectedItem().toString());
            email.putExtra(Intent.EXTRA_TEXT, binding.etRecipe.getText().toString());

            //для того чтобы запросить email клиент устанавливаем тип
            email.setType("message/rfc822");

            startActivity(Intent.createChooser(email, "Отправить письмо на " + to + " с помощью:"));
        }
    }
