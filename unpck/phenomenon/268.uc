class 268 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect1
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.ph_song_of_wind_ta'
	End Object
	Desc="송 오브 윈드" //Song of the Wind
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect1',SpecificStage=0)
}