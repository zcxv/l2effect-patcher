class 264 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect23
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.ph_song_of_earth_ta'
	End Object
	Desc="송 오브 어스" //Song of the Earth
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect23',SpecificStage=0)
}