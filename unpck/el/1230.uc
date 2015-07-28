class 1230 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect44
		AttachOn=AM_LA
		offset=(X=1.000000,Y=0.000000,Z=0.000000)
		EffectClass=Class'LineageEffect.el_prominence_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect49
		EffectClass=Class'LineageEffect.el_prominence_fl'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect51
		AttachOn=AM_LA
		offset=(X=1.000000,Y=0.000000,Z=0.000000)
		EffectClass=Class'LineageEffect.el_prominence_cs'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect50
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.el_prominence_ta'
	End Object
	Desc="프로미넌스" //Prominence
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect44',SpecificStage=0)
	ShotActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect49',SpecificStage=0)
	ShotActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect51',SpecificStage=0)
	ExplosionActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect50',SpecificStage=0)
	FlyingTime=0.400000
}