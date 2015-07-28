class 267 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect2
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.ph_song_of_warding_ta'
	End Object
	Desc="송 오브 와딩" //Song of wading
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect2',SpecificStage=0)
}