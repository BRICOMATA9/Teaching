#include <allegro.h>
#include <logg.h>

int main()
{
    char nf[100]="snd/Rayman_2_music_sample.ogg";
	SAMPLE* s;
	int voice;

	if (allegro_init() != 0) {
		printf("Error initialising Allegro.\n");
		return 1;
	}

	if (install_sound(DIGI_AUTODETECT, MIDI_NONE, 0) != 0) {
		printf("Error initialising sound: %s\n", allegro_error);
		return 1;
	}
	install_timer();

	s = logg_load(nf);
	if (!s) {
		printf("Error loading %s\n", nf);
		return 1;
	}

	voice = play_sample(s, 255, 128, 1000, 0);
	printf("voice=%d\n", voice);

	rest(s->len*1000/s->freq);

	destroy_sample(s);

	return 0;
}
END_OF_MAIN()
