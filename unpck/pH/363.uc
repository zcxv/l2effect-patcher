class 363 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect65
		AttachOn=AM_LA
		SpawnDelay=1.000000
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.ph_song_of_meditation_ta'
	End Object
	Desc="송 오브 메디테이션" //Song of Meditation
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect65',SpecificStage=0)
}