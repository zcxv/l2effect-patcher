class 269 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect0
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.ph_song_of_hunter_ta'
	End Object
	Desc="송 오브 헌터" //Song of the Hunter
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect0',SpecificStage=0)
}