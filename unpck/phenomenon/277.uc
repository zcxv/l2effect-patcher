class 277 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect8
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.ph_dance_of_light_ta'
	End Object
	Desc="댄스 오브 라이트" //Dance of Light
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect8',SpecificStage=0)
}